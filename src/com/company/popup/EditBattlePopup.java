package com.company.popup;

import com.company.Arena;
import com.company.Battle;
import com.company.Config;
import com.company.infinity.Infinity;
import com.company.infinity.Node;
import com.company.infinity.Table;
import com.company.infinity.TableCell;

import java.time.LocalTime;
import java.util.ArrayList;

public class EditBattlePopup extends BattlePopup {
    public EditBattlePopup(Battle item) {
        super(item);
        beginTime.setText(item.getBeginTime().toString());
        endTime.setText(item.getEndTime().toString());
        arena.setValue(item.getArena());
        popularityPercent.setText((item.getPopularityString()));
        trainer1.setValue(item.getTrainer1());
        trainer2.setValue(item.getTrainer2());
    }

    @Override
    public void apply() {
        // Find battle in table
        ArrayList<Node> nodes = Infinity.instance.nodeList.getNodes();
        String currentCellText = item.getTrainer1().getName() + " vs " + item.getTrainer2().getName();
        
        TableCell cell = null;
        Table table = null;

        for (Node node : nodes) {
            if (node instanceof Table) {
                table = (Table) node;
            }

            if (node instanceof TableCell) {
                TableCell currentCell = (TableCell) node;
                if (currentCell.text.equals(currentCellText)) {
                    cell = currentCell;
                }
            }
            
            if (table != null && cell != null) {
                break;
            }
        }

        nodes.remove(cell);

        // // TODO: Rename item to battle, this is not consistent at all
        item.setBeginTime(LocalTime.parse(beginTime.getText()));
        item.setEndTime(LocalTime.parse(endTime.getText()));
        item.setArena(arena.getValue());
        item.setPopularity(Integer.parseInt(popularityPercent.getText()));
        item.setTrainer1(trainer1.getValue());
        item.setTrainer2(trainer2.getValue());

        int xMultiplier = item.getEndTime().getHour() - item.getBeginTime().getHour();
        TableCell newCell = new TableCell(item.getTrainer1().getName() + " vs " + item.getTrainer2().getName());
        newCell.onMouseClick(e -> {
            new EditBattlePopup(item);
        });
        
        for (Node node : nodes) {
            if (node instanceof Table) {
                table = (Table) node;
                break;
            }
        }

        if (table != null) {
            table.addCell(Arena.list.indexOf(arena.getValue()), item.getBeginTime().getHour() - Config.SCHEDULE_BEGIN_HOUR, 1f, xMultiplier, newCell);
        }
    }

    @Override
    public void delete() {
        System.out.println(1);
        ArrayList<Node> nodes = Infinity.instance.nodeList.getNodes();
        String currentCellText = item.getTrainer1().getName() + " vs " + item.getTrainer2().getName();
        
        TableCell cell = null;
        Table table = null;

        for (Node node : nodes) {
            if (node instanceof Table) {
                table = (Table) node;
            }

            if (node instanceof TableCell) {
                TableCell currentCell = (TableCell) node;
                if (currentCell.text.equals(currentCellText)) {
                    cell = currentCell;
                }
            }
            
            if (table != null && cell != null) {
                break;
            }
        }
        nodes.remove(cell);
    }
}
