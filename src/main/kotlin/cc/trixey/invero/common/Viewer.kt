package cc.trixey.invero.common

import java.util.*

/**
 * @author Arasple
 * @since 2022/12/20 20:35
 */
interface Viewer {

    val uuid: UUID

    fun isAvailable(): Boolean

    fun <T> getInstance(): T

    fun <T> getInstanceSafe() = if (isAvailable()) getInstance() else null

}