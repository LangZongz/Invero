package cc.trixey.invero.common

/**
 * @author Arasple
 * @since 2022/12/20 20:04
 */
interface Window : PanelContainer, Gridable {

    /**
     * Viewers of this window
     *
     * Support for mutiple viewers is only for audience usage.
     * For standard user-specific GUI, you are expected to create individual windows
     */
    val viewers: Set<Viewer>

    /**
     * Title of this window
     */
    var title: String

    /**
     * for Minecraft inventories:
     *
     * Size = container size + 36(player inventory)
     */
    val size: Int

    /**
     * Proxy inventory
     */
    val inventory: ProxyInventory

    /**
     * Locating slot index
     */
    fun locate(x: Int, y: Int): Int

    /**
     * Locating panels' occupied slots
     *
     * @return a set of Slots (INT)
     */
    fun locatePanel(panel: Panel): Set<Int>

    /**
     * Open this window for a viewer
     */
    fun open(viewer: Viewer)

    /**
     * Close this window
     */
    fun close(viewer: Viewer)

    /**
     * Render panels
     */
    fun render()

    fun <T : Viewer> forViewers(block: (it: T) -> Unit) = viewers
        .filter { it.isAvailable() }
        .forEach {
            block(it.getInstance())
        }

}