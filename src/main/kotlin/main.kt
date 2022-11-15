import jdk.jfr.DataAmount

fun main() {
    val cardType = "VK Pay"
    val amount = 1_000
    val previousAmount = 165_000

    val finalCommission = commission(cardType = cardType, previousAmount = previousAmount, amount = amount)
    println("Card: $cardType, Amount: $amount, Commission: $finalCommission")
}

fun commission(cardType: String = "VK Pay", previousAmount: Int = 0, amount: Int): Any {
    val limit = 75_000
    val overLimit = limit - previousAmount - amount
    val minCommissionMasterMaestro = 20
    val commissionMasterMaestro = 0.006
    val minCommissionVisaMir = 35
    val commissionVisaMir = 0.0075
    val finalCommissionVisaMir = amount * commissionVisaMir

    return when(cardType) {
        "Mastercard", "Maestro" -> if (limit < 0) (kotlin.math.abs(limit) * commissionMasterMaestro + minCommissionMasterMaestro).toInt() else 0
        "Visa", "Mir" -> if (finalCommissionVisaMir > commissionVisaMir) finalCommissionVisaMir.toInt() else commissionVisaMir
        else -> 0
    }
}