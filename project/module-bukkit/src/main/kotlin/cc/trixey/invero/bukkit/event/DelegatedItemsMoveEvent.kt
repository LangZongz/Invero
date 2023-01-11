package cc.trixey.invero.bukkit.event

import cc.trixey.invero.bukkit.BukkitViewer
import cc.trixey.invero.bukkit.BukkitWindowHolder
import cc.trixey.invero.common.Viewer
import cc.trixey.invero.common.Window
import cc.trixey.invero.common.event.EventType
import cc.trixey.invero.common.event.WindowItemsMoveEvent
import org.bukkit.event.inventory.InventoryClickEvent

/**
 * Invero
 * cc.trixey.invero.bukkit.event.DelegatedItemsMoveEvent
 *
 * @author Arasple
 * @since 2023/1/6 12:16
 */
@JvmInline
value class DelegatedItemsMoveEvent(
    override val event: InventoryClickEvent
) : WindowItemsMoveEvent, DelegatedInventoryEvent {

    override var isCancelled: Boolean
        get() = event.isCancelled
        set(value) {
            event.isCancelled = value
        }

    override fun getViewer(): Viewer {
        return BukkitViewer(event.whoClicked.uniqueId)
    }

    override fun getWindow(): Window {
        return (event.clickedInventory!!.holder as BukkitWindowHolder).window
    }

    override fun getType(): EventType {
        return EventType.ITEMS_MOVE
    }

}