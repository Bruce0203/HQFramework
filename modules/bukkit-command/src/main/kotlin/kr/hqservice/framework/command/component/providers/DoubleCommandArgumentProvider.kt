package kr.hqservice.framework.command.component.providers

import kr.hqservice.framework.command.component.HQCommandArgumentProvider
import kr.hqservice.framework.global.core.component.Component
import org.bukkit.Location
import org.bukkit.command.CommandSender

@Component
class DoubleCommandArgumentProvider : HQCommandArgumentProvider<Double> {
    override fun getTabComplete(
        commandSender: CommandSender,
        location: Location?,
        argumentLabel: String?
    ): List<String> {
        return listOf(argumentLabel ?: "숫자")
    }

    override fun getResult(commandSender: CommandSender, string: String?): Boolean {
        return string?.toDoubleOrNull() != null
    }

    override fun getFailureMessage(commandSender: CommandSender, string: String?, argumentLabel: String?): String? {
        return "${argumentLabel ?: "숫자"}을(를) 입력해야 합니다."
    }

    override fun cast(string: String): Double {
        return string.toDouble()
    }
}