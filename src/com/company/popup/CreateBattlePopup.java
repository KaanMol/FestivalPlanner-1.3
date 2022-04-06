package com.company.popup;

import com.company.Arena;
import com.company.Battle;
import com.company.Config;
import com.company.Schedule;
import com.company.infinity.Infinity;
import com.company.infinity.Node;
import com.company.infinity.Table;
import com.company.infinity.TableCell;

import java.time.LocalTime;
import java.util.ArrayList;

public class CreateBattlePopup extends BattlePopup {
    public CreateBattlePopup() {
        super(null);
    }

    @Override
    public void apply() {
        Battle battle = new Battle(LocalTime.parse(beginTime.getText()), LocalTime.parse(endTime.getText()), 0
                ,arena.getValue(), trainer1.getValue(), trainer2.getValue());

        int givenPopularity = Integer.parseInt(popularityPercent.getText());
        if (!battle.populationIsAvailable(givenPopularity)) {
            givenPopularity = battle.availablePopulationPercent();
        }
        battle.setPopularity(givenPopularity);

        ArrayList<Node> nodes = Infinity.instance.nodeList.getNodes();
        Table table = null;
        int xMultiplier = battle.getEndTime().getHour() - battle.getBeginTime().getHour();
        TableCell cell = new TableCell(battle.getTrainer1().getName() + " vs " + battle.getTrainer2().getName());
        cell.onMouseClick(e -> {
            new EditBattlePopup(battle);
            System.out.println(battle.toString());
        });

        for (Node node : nodes) {
            if (node instanceof Table) {
                table = (Table) node;
                break;
            }
        }

        if (table != null) {
            table.addCell(Arena.list.indexOf(arena.getValue()), battle.getBeginTime().getHour() - Config.SCHEDULE_BEGIN_HOUR, 1f, xMultiplier, cell);
        }
        this.close();
    }

    @Override
    public void delete() {
        //note that there is nothing to delete
    }
}
