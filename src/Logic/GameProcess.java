package Logic;

import java.util.Scanner;

public class GameProcess {
    private final Town town;
    private final Logic logic;
    private final Bot comp;
    private Field battle;
    public static final Scanner scan = new Scanner(System.in);
    public static final FileManager manager = new FileManager();
    public GameProcess() {
        logic = new Logic(scan);
        comp = new Bot();
        town = new Town(logic);
    }
    public GameProcess(SavedGame sGame) {
        logic = new Logic(scan, sGame);
        comp = new Bot();
        town = sGame.getTown();
    }
    public void start() {
        town.start(town, logic);
        System.out.println(town);
        System.out.println("Maps to load:");
        manager.showMaps();
        battle = manager.LoadMap(scan.next());
        logic.setField(battle);
    }
    public void process() {
        logic.start();
        System.out.println(logic.shop);
        System.out.println(battle);
        while (logic.isContSpawn())
        {
            logic.init();
            if(logic.isContSpawn()) { comp.addNew(logic, comp);}
        }
        logic.setUnits(logic.player.getUnits());
        logic.setUnits(comp.getUnits());
        System.out.println(battle);
        while(!logic.player.getUnits().isEmpty() && !comp.getUnits().isEmpty())
        {
            comp.showUnits();
            logic.usrMove(comp, town);
            logic.setUnits(logic.player.getUnits());
            if(!comp.getUnits().isEmpty() && !logic.player.getUnits().isEmpty())
            {
                comp.botMove(logic, comp);
                logic.setUnits(comp.getUnits());
            }
            System.out.println(battle);
        }
    }
    public void end() {
        if(logic.player.getUnits().isEmpty())
        {
            System.out.println("You LOSE!!!");
            if(logic.shop.getBudget() == 0 && town.getBuildings().size() == 1 && town.getBank() != null) {
                System.out.println("YOUR LOVELY BAUMAN'S GATE BANK");
            }
        }
        else if(comp.getUnits().isEmpty())
        {
            System.out.println("You WIN!!!");
            town.setWood(town.getWood() + 5 * logic.player.getUnits().size());
            town.setRock(town.getRock() + 5 * logic.player.getUnits().size());
            System.out.println("Do you want to save your town? (Y | N)");
            if(scan.next().equals("Y"))
            {
                System.out.println("Enter file name");
                manager.SaveGame(scan.next(), logic.player, logic.shop, town);
            }
        }
    }
}
