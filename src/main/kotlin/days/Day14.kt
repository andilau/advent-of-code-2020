package days

class Day14 : Day(14) {
    private val maskPattern = """mask = ([01X]{36})""".toRegex()
    @Suppress("RegExpRedundantEscape")
    private val memPattern = """mem\[(\d+)\] = (\d+)""".toRegex()

    override fun partOne(): Any {
        var mask = BitMaskSystem()
        val memory: MutableMap<Int, Long> = mutableMapOf()
        inputList.forEach {
            if (maskPattern.matches(it)) {
                mask = BitMaskSystem(maskPattern.find(it)!!.groupValues[1])
            } else if (memPattern.matches(it)) {
                val (address, number) = memPattern.find(it)!!.destructured
                memory[address.toInt()] = mask.convert(number.toLong())
            }
        }
        return memory.values.sum()
    }

    class BitMaskSystem(private val mask: String = "000000000000000000000000000000000000") {
        private val andMask: Long = mask.replace('X', '1').toLong(2)
        private val orMask: Long = mask.replace('X', '0').toLong(2)

        fun convert(number: Long) = number.or(orMask).and(andMask)

        override fun toString(): String = "BitMaskSystem(mask='$mask')"
    }

    override fun partTwo(): Any {
        val memory: MutableMap<Long, Long> = mutableMapOf()
        var mad = MemoryAddressDecoder()
        inputList.forEach {
            if (it.startsWith("mask = ")) {
                mad = MemoryAddressDecoder(it.substringAfter("mask = "))
            } else if (memPattern.matches(it)) {
                val (addressString, numberString) = memPattern.find(it)!!.destructured
                val addressesFor: List<Long> = mad.getAddressesFor(addressString.toLong())
                addressesFor.forEach { address -> memory[address] = numberString.toLong() }
            }
        }
        return memory.values.sum()
    }

    class MemoryAddressDecoder(private val mask: String = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX") {
        private val maskNull = mask.replace('X', '0').toLong(2)
        private val replace = mask.replace('0', '1').replace('X', '0').toLong(2)

        fun getAddressesFor(address: Long): List<Long> {
            val baseAddress = address or maskNull and replace
            val addresses = mutableListOf<Long>(baseAddress)

            for ((i, c) in mask.withIndex()) {
                if (c == 'X') {
                    addresses.indices.forEach {
                        addresses.add(addresses[it] + 1L.shl(35 - i))
                    }
                }
            }
            return addresses
        }

        override fun toString(): String = "MemoryAddressDecoder(mask='$mask')"
    }

    private fun Long.toBinaryString(): String = toString(2).padStart(36, '0')
}