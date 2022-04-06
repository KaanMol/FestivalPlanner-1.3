package com.company;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.company.infinity.Button;
import com.company.infinity.FPS;

import java.io.File;

import com.company.infinity.Infinity;
import com.company.popup.CreatePopulationPopup;
import com.company.simulation.Camera;
import com.company.simulation.NPC;
import com.company.simulation.SimulationView;
import com.company.simulation.VisitorNPC;
import com.company.simulation.map.TileMap;
import com.company.infinity.Sound;
import com.company.infinity.TabPane;
import com.company.infinity.Table;
import com.company.infinity.Text;
import com.company.infinity.TableCell;
import com.company.infinity.Unit;
import com.company.popup.CreateBattlePopup;
import com.company.popup.EditBattlePopup;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {
    public Infinity infinity;

    public static void main(String[] args) {
        launch(Main.class);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("InfinityWindow");
        Schedule schedule = new Schedule(100);

        Infinity infinity = new Infinity(800, 600);
        Scene scene = new Scene(new Group(Infinity.instance));

        primaryStage.setScene(scene);
        primaryStage.show();

        double windowDelteWidth = primaryStage.getWidth() - scene.getWidth();
        double windowDeltaHeight = primaryStage.getHeight() - scene.getHeight();

        primaryStage.widthProperty().addListener((observable, oldValue, newValue) -> {
            infinity.setWidth(newValue.doubleValue() - windowDelteWidth);
        });

        primaryStage.heightProperty().addListener((observable, oldValue, newValue) -> {
            infinity.setHeight(newValue.doubleValue() - windowDeltaHeight);
        });

        infinity.start();

        TileMap map = new TileMap();
        SimulationView view = new SimulationView(map);
        view.width = Unit.vw(100);
        view.height = Unit.vh(100).subtract(Unit.px(50));
        view.y = 50;

        for (int i = 0; i < schedule.getPopulation(); i++) {
            NPC npc = new VisitorNPC(map);
            npc.setTarget(map.getAreas().get((int)(3 * Math.random())));
            npc.spawn();
            view.getNpcs().add(npc);
        }


        TabPane tabPane = new TabPane(0, 0, Unit.vw(100), Unit.vh(100));
        
        tabPane.addTab("Schedule");
        tabPane.addTab("Simulation");
        tabPane.setActiveTab("Schedule");

        new Arena("Main Arena");
        new Arena("Side Arena");
        new Arena("Practice Arena");

        new Trainer("Kanye", "Muk");
        new Trainer("Dirk", "Mr. Mime");
        new Trainer("Owen", "Lombre");
        new Trainer("Koen", "Slakoth");
        new Trainer("Wouter", "Snorlax");
        new Trainer("Niels", "Wooper");
        new Trainer("Kaan", "Charizard");

        Table table = new Table(0, 51, Unit.vw(100), Unit.vh(100).subtract(Unit.px(50)));
        table.columnsFromList(Arena.list.stream().map(Arena::getArenaName).collect(Collectors.toList()));
        table.rowsFromList(IntStream.range(Config.SCHEDULE_BEGIN_HOUR, Config.SCHEDULE_END_HOUR).boxed().collect(Collectors.toList()));

        Button create = new Button(404, 0, Unit.px(100), Unit.px(50), "Create");
        Button exportButton = new Button(505, 0, Unit.px(100), Unit.px(50), "Export data");
        Button importButton = new Button(606, 0, Unit.px(100), Unit.px(50), "Import data");
        Button setPopulation = new Button(707, 0, Unit.px(100), Unit.px(50), "Set Population");
        Text currentPopulation = new Text("Default population: " + schedule.getPopulationString(), 820, 30);

        create.onMouseClick(e -> {
            new CreateBattlePopup();
        });

        setPopulation.onMouseClick(e -> {
            System.out.println("Set Population Triggered!");
            new CreatePopulationPopup(schedule);
        } );

        exportButton.onMouseClick(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("schedule","*.schedule"));
            fileChooser.setInitialFileName("Tournament");
            File chosenFile = fileChooser.showSaveDialog(primaryStage);
            schedule.output(chosenFile);
        });

        importButton.onMouseClick(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("schedule","*.schedule"));
            File chosenFile = fileChooser.showOpenDialog(primaryStage);
            schedule.input(chosenFile);
            
            for (Battle battle : Battle.list) {
                int xMultiplier = battle.getEndTime().getHour() - battle.getBeginTime().getHour();

                TableCell cell = new TableCell(battle.getTrainer1().getName() + " vs " + battle.getTrainer2().getName());
                cell.onMouseClick(cellEvent -> {
                    new EditBattlePopup(battle);
                });

                table.addCell(Arena.list.indexOf(battle.getArena()), battle.getBeginTime().getHour() - Config.SCHEDULE_BEGIN_HOUR, 1f, xMultiplier, cell);
            }
        });

        tabPane.addNode("Schedule", create);
        tabPane.addNode("Schedule", exportButton);
        tabPane.addNode("Schedule", importButton);
        tabPane.addNode("Schedule", table);
        tabPane.addNode("Schedule", setPopulation);
        tabPane.addNode("Schedule", currentPopulation);

        tabPane.addNode("Simulation", view);
        tabPane.addNode("Simulation", currentPopulation);
    }
}
