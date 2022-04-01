package com.company;

import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.company.infinity.Button;
import java.io.File;

import com.company.infinity.Infinity;
import com.company.simulation.Camera;
import com.company.simulation.map.TileMap;
import com.company.infinity.Sound;
import com.company.infinity.TabPane;
import com.company.infinity.Table;
import com.company.infinity.Text;
import com.company.infinity.Unit;
import com.company.popup.CreateBattlePopup;
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

        Schedule schedule = new Schedule(100);
        
        TabPane tabPane = new TabPane(0, 0, Unit.vw(100), Unit.vh(100));
        
        tabPane.addTab("Schedule");
        tabPane.addTab("Simulation");
        tabPane.setActiveTab("Schedule");

        Button create = new Button(250, 0, Unit.px(100), Unit.px(50), "Create battle");
        // Button musicPlay = new Button(404, 0, Unit.px(100), Unit.px(50), "Play Music");
        // Button musicPause = new Button(505, 0, Unit.px(100), Unit.px(50), "Pause Music");
        Button exportButton = new Button(351, 0, Unit.px(100), Unit.px(50), "Export data");
        Button importButton = new Button(452, 0, Unit.px(100), Unit.px(50), "Import data");

        new Arena("School");
        new Arena("BattleArena 1");
        new Arena("BattleArena 2");

        new Trainer("Niels", "Dirk");
        new Trainer("Owen", "Kaan");

        Sound sound = new Sound("test.mp3");
        sound.player.setVolume(0.02);

        create.onMouseClick(e -> {
            System.out.println("Create triggered!");
            new CreateBattlePopup();
        });

        // musicPlay.onMouseClick(e -> {
        //     System.out.println("Starting music");
        //     sound.player.play();
        // });

        // musicPause.onMouseClick(e -> {
        //     System.out.println("Music paused!");
        //     sound.player.pause();
        // });

        exportButton.onMouseClick(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("schedule","*.schedule"));
            fileChooser.setInitialFileName("Tournament");
            File chosenFile = fileChooser.showSaveDialog(primaryStage);
            schedule.output(chosenFile);
        });

        importButton.onMouseClick(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("schedule","*.schedule"));
            File chosenFile = fileChooser.showOpenDialog(primaryStage);
            schedule.input(chosenFile);
        });

        Table table = new Table(0, 51, Unit.vw(100), Unit.vh(100).subtract(Unit.px(50)));
        table.columnsFromList(Arena.list.stream().map(Arena::getArenaName).collect(Collectors.toList()));
        table.rowsFromList(IntStream.range(Config.SCHEDULE_BEGIN_HOUR, Config.SCHEDULE_END_HOUR).boxed().collect(Collectors.toList()));

        tabPane.addNode("Schedule", create);
        // tabPane.addNode("Schedule", musicPlay);
        // tabPane.addNode("Schedule", musicPause);
        tabPane.addNode("Schedule", exportButton);
        tabPane.addNode("Schedule", importButton);
        tabPane.addNode("Schedule", table);

        // tabPane.addNode("Simulation", new TileMap());
    }
}
