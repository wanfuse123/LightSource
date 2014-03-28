package ykt.BeYkeRYkt.LightSource;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import ykt.BeYkeRYkt.LightSource.GUIMenu.CustomGUIMenu;

public class MainCommand implements CommandExecutor{

	@Override
	  public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		
		if(sender instanceof Player){
		Player player = (Player) sender;
			if(command.getName().equalsIgnoreCase("ls")){
				if(!LightSource.getInstance().getGUI()){
				if(args.length == 0){
				player.sendMessage(ChatColor.GOLD + "#========#" + ChatColor.GREEN + LightSource.getInstance().getName() + ChatColor.GOLD + "#========#");
				player.sendMessage("- /ls info" + ChatColor.YELLOW +"- Information about plugin.");
				
				if(player.hasPermission("lightsource.admin")){
					player.sendMessage("- /ls advanced-item " + ChatColor.GREEN + "[true/false]" + ChatColor.YELLOW +"- Enabling/Disabling advanced listener for items.");
					player.sendMessage("- /ls advanced-entity " + ChatColor.GREEN + "[true/false]" + ChatColor.YELLOW +"- Enabling/Disaling advanced listener for entity.");
					player.sendMessage("- /ls world [worldName] " + ChatColor.GREEN + "[true/false]" + ChatColor.YELLOW +"- Enabling/Disaling lighting for world.");
					player.sendMessage("- /ls gui [true/false]" + ChatColor.YELLOW +"- Enabling/Disabling GUI Menu");
					player.sendMessage("- /ls debug [true/false]" + ChatColor.YELLOW +"- Enabling/Disabling debug mode");
					player.sendMessage("- /ls reload " + ChatColor.YELLOW +"- Reload plugin");
				}
				//Args >1
				}else if(args.length == 1){
				  if(args[0].equalsIgnoreCase("gui")){
					  if(player.hasPermission("lightsource.admin")){
						  player.sendMessage(ChatColor.RED + "Need more arguments!");
						  player.sendMessage(ChatColor.YELLOW + "Description: " + ChatColor.WHITE + "Enabling/Disabling GUI Menu");
						  }else{
							  player.sendMessage(ChatColor.RED + "You do not have permission");
						  }
				  }else if(args[0].equalsIgnoreCase("debug")){
					  if(player.hasPermission("lightsource.admin")){
						  player.sendMessage(ChatColor.RED + "Need more arguments!");
						  player.sendMessage(ChatColor.YELLOW + "Description: " + ChatColor.WHITE + "Enabling/Disabling debug mode");
						  }else{
							  player.sendMessage(ChatColor.RED + "You do not have permission");
						  }
				  }else
				  if(args[0].equalsIgnoreCase("info")){

					  player.sendMessage(ChatColor.GREEN + "Plugin: " + ChatColor.GOLD + LightSource.getInstance().getName());
					  player.sendMessage(ChatColor.GREEN + "Version: " + ChatColor.GOLD + LightSource.getInstance().getDescription().getVersion());
					  player.sendMessage(ChatColor.GREEN + "Developer: " + ChatColor.GOLD + LightSource.getInstance().getDescription().getAuthors());
					  player.sendMessage(ChatColor.GREEN + "Description: " + ChatColor.WHITE + LightSource.getInstance().getDescription().getDescription());
					 
				  }else
				  if(args[0].equalsIgnoreCase("advanced-item")){
					  if(player.hasPermission("lightsource.admin")){
					  player.sendMessage(ChatColor.RED + "Need more arguments!");
					  player.sendMessage(ChatColor.YELLOW + "Description: " + ChatColor.WHITE + "Enabling/Disabling advanced listener for items");
					  }else{
						  player.sendMessage(ChatColor.RED + "You do not have permission");
					  }
				  }else if(args[0].equalsIgnoreCase("advanced-entity")){
					  if(player.hasPermission("lightsource.admin")){
					  player.sendMessage(ChatColor.RED + "Need more arguments!");
					  player.sendMessage(ChatColor.YELLOW + "Description: " + ChatColor.WHITE + "Enabling/Disabling advanced listener for entity");
				  }else{
					  player.sendMessage(ChatColor.RED + "You do not have permission");
				  }
				  }else if(args[0].equalsIgnoreCase("world")){
					  if(player.hasPermission("lightsource.admin")){
					  player.sendMessage(ChatColor.RED + "Need more arguments!");
					  player.sendMessage(ChatColor.YELLOW + "Description: " + ChatColor.WHITE + "Enabling/Disaling lighting for world");
					  }else{
						  player.sendMessage(ChatColor.RED + "You do not have permission");
					  }
				  }else if(args[0].equalsIgnoreCase("reload")){
					  if(player.hasPermission("lightsource.admin")){
					  LightSource.getInstance().reloadConfig();
					  LightSource.getInstance().onDisable();
					  LightSource.getInstance().onEnable();
					  player.sendMessage(ChatColor.GREEN +"Plugin successfully restarted!");
					  }else{
						  player.sendMessage(ChatColor.RED + "You do not have permission");
					  }
				  }else{
					  //Unknow
					  player.sendMessage(ChatColor.RED +"Unknown command.");
				  }
				}else if(args.length == 2){
					  if(args[0].equalsIgnoreCase("gui")){
					  if(player.hasPermission("lightsource.admin")){
						  LightSource.getInstance().getConfig().set("Enable-GUI", Boolean.parseBoolean(args[1]));
						  LightSource.getInstance().getConfig().options().copyDefaults(true);
						  LightSource.getInstance().saveConfig();
						  LightSource.getInstance().getConfig().options().copyDefaults(false);
						  LightSource.getInstance().setGUI(Boolean.parseBoolean(args[1]));
							
						  player.sendMessage(ChatColor.GREEN + "Settings are changed.");
						  }else{
							  player.sendMessage(ChatColor.RED + "You do not have permission");
						  }
				  }else if(args[0].equalsIgnoreCase("debug")){
					  if(player.hasPermission("lightsource.admin")){
						  LightSource.getInstance().getConfig().set("Debug", Boolean.parseBoolean(args[1]));
						  LightSource.getInstance().getConfig().options().copyDefaults(true);
						  LightSource.getInstance().saveConfig();
						  LightSource.getInstance().getConfig().options().copyDefaults(false);
							
						  player.sendMessage(ChatColor.GREEN + "Settings are changed.");
						  }else{
							  player.sendMessage(ChatColor.RED + "You do not have permission");
						  }
				  }else
					  if(args[0].equalsIgnoreCase("info")){
						  player.sendMessage(ChatColor.RED + "Too many arguments.");
					  }else
					  if(args[0].equalsIgnoreCase("advanced-item")){
						  if(player.hasPermission("lightsource.admin")){
						  LightSource.getInstance().getConfig().set("Advanced-Listener.TorchLight", Boolean.parseBoolean(args[1]));
						  LightSource.getInstance().getConfig().options().copyDefaults(true);
						  LightSource.getInstance().saveConfig();
						  LightSource.getInstance().getConfig().options().copyDefaults(false);
						  LightSource.getInstance().registerAdvancedItemListener(Boolean.parseBoolean(args[1]));
							
						  player.sendMessage(ChatColor.GREEN + "Settings are changed.");
						  }else{
							  player.sendMessage(ChatColor.RED + "You do not have permission");
						  }
					  }else if(args[0].equalsIgnoreCase("advanced-entity")){
						  
						  if(player.hasPermission("lightsource.admin")){
						  LightSource.getInstance().getConfig().set("Advanced-Listener.Entity", Boolean.parseBoolean(args[1]));
						  LightSource.getInstance().getConfig().options().copyDefaults(true);
						  LightSource.getInstance().saveConfig();
						  LightSource.getInstance().getConfig().options().copyDefaults(false);
						  LightSource.getInstance().registerAdvancedEntityListener(Boolean.parseBoolean(args[1]));
							
						  player.sendMessage(ChatColor.GREEN + "Settings are changed.");
					  }else{
						  player.sendMessage(ChatColor.RED + "You do not have permission");
					  }
					  }else if(args[0].equalsIgnoreCase("world")){
						  
						  if(player.hasPermission("lightsource.admin")){
						  player.sendMessage(ChatColor.RED + "Need more arguments!");
						  player.sendMessage(ChatColor.YELLOW + "Description: " + ChatColor.WHITE + "Enabling/Disaling lighting for world");
						  }else{
							  player.sendMessage(ChatColor.RED + "You do not have permission");
						  }
					  }else if(args[0].equalsIgnoreCase("reload")){
						  
						  if(player.hasPermission("lightsource.admin")){
						  player.sendMessage(ChatColor.RED + "Too many arguments.");
					  }else{
						  player.sendMessage(ChatColor.RED + "You do not have permission");
					  }
						  
					  }else{
						  //Unknow
						  player.sendMessage(ChatColor.RED +"Unknown command.");
					  }
				}else if(args.length == 3){
					  if(args[0].equalsIgnoreCase("gui")){
						  if(player.hasPermission("lightsource.admin")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
							  }else{
								  player.sendMessage(ChatColor.RED + "You do not have permission");
							  }
					  }else if(args[0].equalsIgnoreCase("debug")){
						  if(player.hasPermission("lightsource.admin")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
							  }else{
								  player.sendMessage(ChatColor.RED + "You do not have permission");
							  }
					  }else
					  if(args[0].equalsIgnoreCase("info")){
						  player.sendMessage(ChatColor.RED + "Too many arguments.");
					  }else
					  if(args[0].equalsIgnoreCase("advanced-item")){
						  if(player.hasPermission("lightsource.admin")){
						  player.sendMessage(ChatColor.RED + "Too many arguments.");
						  }else{
							  player.sendMessage(ChatColor.RED + "You do not have permission");
						  }
					  }else if(args[0].equalsIgnoreCase("advanced-entity")){
						  if(player.hasPermission("lightsource.admin")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
							  }else{
								  player.sendMessage(ChatColor.RED + "You do not have permission");
							  }
						  
					  }else if(args[0].equalsIgnoreCase("world")){
						  if(player.hasPermission("lightsource.admin")){
						  LightSource.getInstance().getConfig().set("Worlds." + args[1], Boolean.parseBoolean(args[1]));
						  LightSource.getInstance().getConfig().options().copyDefaults(true);
						  LightSource.getInstance().saveConfig();
						  LightSource.getInstance().getConfig().options().copyDefaults(false);
						  
						  player.sendMessage(ChatColor.GREEN + "Settings are changed.");
					  }else{
						  player.sendMessage(ChatColor.RED + "You do not have permission");
					  }
					  }else if(args[0].equalsIgnoreCase("reload")){
						  if(player.hasPermission("lightsource.admin")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
							  }else{
								  player.sendMessage(ChatColor.RED + "You do not have permission");
							  }
					  }else{
						  //Unknow
						  player.sendMessage(ChatColor.RED +"Unknown command.");
					  }
				}else{
					  if(args[0].equalsIgnoreCase("gui")){
						  if(player.hasPermission("lightsource.admin")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
							  }else{
								  player.sendMessage(ChatColor.RED + "You do not have permission");
							  }
					  }else if(args[0].equalsIgnoreCase("debug")){
						  if(player.hasPermission("lightsource.admin")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
							  }else{
								  player.sendMessage(ChatColor.RED + "You do not have permission");
							  }
					  }else
					  if(args[0].equalsIgnoreCase("info")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
					  }else
					  if(args[0].equalsIgnoreCase("advanced-item")){
						  if(player.hasPermission("lightsource.admin")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
							  }else{
								  player.sendMessage(ChatColor.RED + "You do not have permission");
							  }
						  
					  }else if(args[0].equalsIgnoreCase("advanced-entity")){
						  if(player.hasPermission("lightsource.admin")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
							  }else{
								  player.sendMessage(ChatColor.RED + "You do not have permission");
							  }
						  
					  }else if(args[0].equalsIgnoreCase("world")){
						  if(player.hasPermission("lightsource.admin")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
							  }else{
								  player.sendMessage(ChatColor.RED + "You do not have permission");
							  }
						  
					  }else if(args[0].equalsIgnoreCase("reload")){
						  if(player.hasPermission("lightsource.admin")){
							  player.sendMessage(ChatColor.RED + "Too many arguments.");
							  }else{
								  player.sendMessage(ChatColor.RED + "You do not have permission");
							  }
					  }else{
						  //Unknow
						  player.sendMessage(ChatColor.RED +"Unknown command.");
					  }
				}
				//GUI :D
			  }else if(LightSource.getInstance().getGUI()){
				  CustomGUIMenu menu = new CustomGUIMenu(LightSource.getInstance().getName(), 9);

				  menu.addItem(getInfo(), 0);
				  
				  if(player.hasPermission("lightsource.admin")){
					  menu.addItem(getAdv_Item(), 1);
					  menu.addItem(getAdv_Ent(), 2);
					  menu.addItem(getWorlds(), 3);
					  menu.addItem(getDebug(), 4);
					  menu.addItem(getGUIEnable(), 5);
					  menu.addItem(getReload(), 6);
					  
				  }
				
				  player.openInventory(menu.getInventory());
			  }
			}
		}
		return true;
	}
	
	
	public ItemStack getInfo(){
		  ItemStack info = new ItemStack(Material.BOOK);
		  ItemMeta meta = info.getItemMeta();
		  meta.setDisplayName("Information");
		  
		  ArrayList<String> list = new ArrayList<String>();
		  list.add(ChatColor.GREEN + "Plugin: " + ChatColor.GOLD + LightSource.getInstance().getName());
		  list.add(ChatColor.GREEN + "Version: " + ChatColor.GOLD + LightSource.getInstance().getDescription().getVersion());
		  list.add(ChatColor.GREEN + "Developer: " + ChatColor.GOLD + LightSource.getInstance().getDescription().getAuthors());
		  meta.setLore(list);
		  info.setItemMeta(meta);
		  
		  return info;
	}
	
	public ItemStack getAdv_Item(){
		  ItemStack advi = new ItemStack(Material.BOOK);
		  ItemMeta meta = advi.getItemMeta();
		  meta.setDisplayName("Advanced item listener");
		  
		  ArrayList list = new ArrayList();
		  list.add(ChatColor.GOLD + "Status: ");
		  list.add(String.valueOf(LightSource.getInstance().getConfig().getBoolean("Advanced-Listener.TorchLight")));
		  meta.setLore(list);
		  advi.setItemMeta(meta);
		  return advi;
	}
	
	public ItemStack getAdv_Ent(){
		  ItemStack adve = new ItemStack(Material.BOOK);
		  ItemMeta meta = adve.getItemMeta();
		  meta.setDisplayName("Advanced entity listener");
		  
		  ArrayList list = new ArrayList();
		  list.add(ChatColor.GOLD + "Status: ");
		  list.add(String.valueOf(LightSource.getInstance().getConfig().getBoolean("Advanced-Listener.Entity")));
		  meta.setLore(list);
		  adve.setItemMeta(meta);
		  return adve;
	}
	
	public ItemStack getWorlds(){
		  ItemStack adve = new ItemStack(Material.MAP);
		  ItemMeta meta = adve.getItemMeta();
		  meta.setDisplayName("Worlds");
		  
		  ArrayList<String> list = new ArrayList<String>();
		  list.add(ChatColor.GOLD + "Click here to change");
		  meta.setLore(list);
		  adve.setItemMeta(meta);
		  return adve;
	}
	
	public ItemStack getReload(){
		  ItemStack adve = new ItemStack(Material.BEDROCK);
		  ItemMeta meta = adve.getItemMeta();
		  meta.setDisplayName("Reload");
		  
		  ArrayList<String> list = new ArrayList<String>();
		  list.add(ChatColor.GOLD + "Reload plugin");
		  meta.setLore(list);
		  adve.setItemMeta(meta);
		  return adve;
	}
	
	public ItemStack getGUIEnable(){
		  ItemStack adve = new ItemStack(Material.PAINTING);
		  ItemMeta meta = adve.getItemMeta();
		  meta.setDisplayName("GUI");
		  
		  ArrayList list = new ArrayList();
		  list.add(ChatColor.GOLD + "Status: ");
		  list.add(String.valueOf(LightSource.getInstance().getConfig().getBoolean("Enable-GUI")));
		  meta.setLore(list);
		  adve.setItemMeta(meta);
		  return adve;
	}
	
	public ItemStack getDebug(){
		  ItemStack adve = new ItemStack(Material.PAPER);
		  ItemMeta meta = adve.getItemMeta();
		  meta.setDisplayName("Debug");
		  
		  ArrayList list = new ArrayList();
		  list.add(ChatColor.GOLD + "Status: ");
		  list.add(String.valueOf(LightSource.getInstance().getConfig().getBoolean("Debug")));
		  meta.setLore(list);
		  adve.setItemMeta(meta);
		  return adve;
	}
}