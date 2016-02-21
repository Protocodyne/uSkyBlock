package us.talabrek.ultimateskyblock.command.admin;

import dk.lockfuglsang.minecraft.command.AbstractCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.talabrek.ultimateskyblock.uSkyBlock;

import java.util.Map;

import static dk.lockfuglsang.minecraft.po.I18nUtil.tr;

/**
 * Command for showing the config-gui.
 */
public class ConfigGUICommand extends AbstractCommand {

    private final uSkyBlock plugin;

    public ConfigGUICommand(uSkyBlock plugin) {
        super("config|c", "usb.admin.config", tr("open GUI for config"));
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String alias, Map<String, Object> data, String... args) {
        if (sender instanceof Player) {
            plugin.getConfigMenu().showMenu((Player) sender,
                    args.length > 0 && args[0].matches("[0-9]*") ? Integer.parseInt(args[0], 10) : 1
            );
            return true;
        }
        return false;
    }
}
