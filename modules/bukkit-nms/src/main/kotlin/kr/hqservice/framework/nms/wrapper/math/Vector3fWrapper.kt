package kr.hqservice.framework.nms.wrapper.math

import kr.hqservice.framework.nms.Version
import kr.hqservice.framework.nms.util.NmsReflectionUtil
import kr.hqservice.framework.nms.util.getFunction
import kr.hqservice.framework.nms.wrapper.NmsWrapper
import kotlin.reflect.KClass

class Vector3fWrapper(
    private val vector3f: Any,
    targetClass: KClass<*>,
    reflectionUtil: NmsReflectionUtil
) : NmsWrapper {
    private val getXFunction = reflectionUtil.getFunction(targetClass, "getX", Version.V_15.handleFunction("b"))
    private val getYFunction = reflectionUtil.getFunction(targetClass, "getY", Version.V_15.handleFunction("c"))
    private val getZFunction = reflectionUtil.getFunction(targetClass, "getZ", Version.V_15.handleFunction("d"))

    fun getX(): Float = getXFunction.call(vector3f) as Float
    fun getY(): Float = getYFunction.call(vector3f) as Float
    fun getZ(): Float = getZFunction.call(vector3f) as Float

    override fun getUnwrappedInstance(): Any {
        return vector3f
    }
}