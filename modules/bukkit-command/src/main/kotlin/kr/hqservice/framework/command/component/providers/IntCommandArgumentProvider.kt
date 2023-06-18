package kr.hqservice.framework.command.component.providers

import kr.hqservice.framework.command.component.CommandContext
import kr.hqservice.framework.command.component.HQCommandArgumentProvider
import kr.hqservice.framework.global.core.component.Component
import org.bukkit.Location
import org.bukkit.command.CommandSender

@Component
class IntCommandArgumentProvider : HQCommandArgumentProvider<Int> {
    override fun getTabComplete(context: CommandContext, location: Location?, argumentLabel: String?): List<String> {
        return listOf(argumentLabel ?: "정수")
    }

    override fun getResult(commandSender: CommandSender, string: String?): Boolean {
        return string?.toIntOrNull() != null
    }

    override fun getFailureMessage(commandSender: CommandSender, string: String?, argumentLabel: String?): String {
        return "${argumentLabel ?: "정수"}을(를) 입력해야 합니다."
    }

    override fun cast(string: String): Int {
        return string.toInt()
    }
}