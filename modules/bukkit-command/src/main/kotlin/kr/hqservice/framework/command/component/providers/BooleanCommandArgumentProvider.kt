package kr.hqservice.framework.command.component.providers

import kr.hqservice.framework.command.component.HQCommandArgumentProvider
import kr.hqservice.framework.global.core.component.Component
import org.bukkit.command.CommandSender
import javax.xml.stream.Location

@Component
class BooleanCommandArgumentProvider : HQCommandArgumentProvider<Boolean> {
    override fun getTabComplete(
        commandSender: CommandSender,
        location: Location,
        argumentLabel: String?
    ): List<String> {
        return listOf(argumentLabel ?: "frue/false")
    }

    override fun getResult(commandSender: CommandSender, string: String?): Boolean {
        return string.equals("true", true) || string.equals("false", true)
    }

    override fun getFailureMessage(commandSender: CommandSender, string: String?, argumentLabel: String?): String? {
        return "${argumentLabel ?: "true/false"}을(를) 입력해야 합니다."
    }

    override fun cast(string: String): Boolean {
        return string.toBoolean()
    }
}