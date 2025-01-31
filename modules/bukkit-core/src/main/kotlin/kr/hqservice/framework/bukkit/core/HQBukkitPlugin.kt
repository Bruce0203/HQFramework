package kr.hqservice.framework.bukkit.core

import kr.hqservice.framework.global.core.HQPlugin
import kr.hqservice.framework.global.core.component.registry.ComponentRegistry
import org.bukkit.plugin.PluginDescriptionFile
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.plugin.java.JavaPluginLoader
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import java.io.File
import java.util.logging.Logger

abstract class HQBukkitPlugin : JavaPlugin, HQPlugin, KoinComponent {
    constructor() : super()
    internal constructor(loader: JavaPluginLoader, description: PluginDescriptionFile, dataFolder: File, file: File) : super(loader, description, dataFolder, file)

    protected open val componentRegistry: ComponentRegistry by inject { parametersOf(this) }

    final override fun onLoad() {
        onPreLoad()
        onPostLoad()
    }

    final override fun onEnable() {
        onPreEnable()
        loadConfigIfExist()
        componentRegistry.setup()
        onPostEnable()
    }

    final override fun onDisable() {
        onPreDisable()
        componentRegistry.teardown()
        onPostDisable()
    }

    fun reload() {
        onDisable()
        onEnable()
    }

    final override fun getJar(): File {
        return super.getFile()
    }

    final override fun getLogger(): Logger {
        return super.getLogger()
    }

    final override fun getPluginClassLoader(): ClassLoader {
        return super.getClassLoader()
    }

    private fun loadConfigIfExist() {
        val stream = getResource("config.yml") ?: return
        val file = File(dataFolder, "config.yml")
        if(!dataFolder.exists()) dataFolder.mkdirs()
        if(!file.exists()) file.bufferedWriter().use {  writer ->
            stream.reader().readLines().forEach {
                writer.appendLine(it)
            }
        }
    }
}