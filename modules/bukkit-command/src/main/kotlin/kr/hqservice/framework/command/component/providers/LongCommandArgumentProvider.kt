package kr.hqservice.framework.command.component.providers

import kr.hqservice.framework.command.component.CommandContext
import kr.hqservice.framework.command.component.HQCommandArgumentProvider
import kr.hqservice.framework.global.core.component.Component
import org.bukkit.Location
import org.bukkit.command.CommandSender

@Component
class LongCommandArgumentProvider : HQCommandArgumentProvider<Long> {
    override fun getTabComplete(
        context: CommandContext,
        location: Location?,
        argumentLabel: String?
    ): List<String> {
        return listOf(argumentLabel ?: "숫자")
    }

    override fun getResult(context: CommandContext, string: String?): Boolean {
        return string?.toLongOrNull() != null
    }

    override fun getFailureMessage(commandSender: CommandSender, string: String?, argumentLabel: String?): String? {
        return "${argumentLabel ?: "숫자"}을(를) 입력해야 합니다."
    }

    override fun cast(context: CommandContext, string: String): Long {
        return string.toLong()
    }
}