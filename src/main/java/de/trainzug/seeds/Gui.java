package de.trainzug.seeds;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Gui extends JFrame {
    private JPanel guiPanel;
    private JButton start;
    private JTextField currentSeed;
    private JPanel layerDisplayPanel;
    private JSpinner dirtCountInput;
    private JSpinner clayCountInput;
    private JSpinner ironCountInput;
    private JSpinner copperCountInput;
    private JSpinner coalCountInput;
    private JSpinner tinCountInput;
    private JSpinner crudeCountInput;
    private JSpinner totalCountInput;
    private JLabel triesLabel;
    private JCheckBox dirtVeinsRadio;
    private JSpinner dirtVeinsInput;
    private JCheckBox dirtCountRadio;
    private JCheckBox clayCountRadio;
    private JCheckBox ironCountRadio;
    private JCheckBox copperCountRadio;
    private JCheckBox coalCountRadio;
    private JCheckBox tinCountRadio;
    private JCheckBox crudeCountRadio;
    private JCheckBox totalCountRadio;
    private JCheckBox clayVeinsRadio;
    private JSpinner clayVeinsInput;
    private JCheckBox ironVeinsRadio;
    private JCheckBox copperVeinsRadio;
    private JCheckBox coalVeinsRadio;
    private JCheckBox tinVeinsRadio;
    private JCheckBox crudeVeinsRadio;
    private JCheckBox totalVeinsRadio;
    private JSpinner totalVeinsInput;
    private JSpinner crudeVeinsInput;
    private JSpinner tinVeinsInput;
    private JSpinner coalVeinsInput;
    private JSpinner copperVeinsInput;
    private JSpinner ironVeinsInput;
    private JButton stop;
    private JCheckBox dirt2by2sCheckbox;
    private JSpinner dirt2by2sInput;
    private JCheckBox clay2by2sCheckbox;
    private JCheckBox iron2by2sCheckbox;
    private JCheckBox copper2by2sCheckbox;
    private JCheckBox coal2by2sCheckbox;
    private JCheckBox tin2by2sCheckbox;
    private JCheckBox crude2by2sCheckbox;
    private JCheckBox total2by2sCheckbox;
    private JSpinner clay2by2sInput;
    private JSpinner iron2by2sInput;
    private JSpinner copper2by2sInput;
    private JSpinner coal2by2sInput;
    private JSpinner tin2by2sInput;
    private JSpinner crude2by2sInput;
    private JSpinner total2by2sInput;

    private boolean run = true;


    public Gui() {
        super();

        this.layerDisplayPanel.setLayout(null);
        this.layerDisplayPanel.setSize(640, 640);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(guiPanel);
        this.pack();

        dirtVeinsInput.setModel(new SpinnerNumberModel(0, 0, 6, 1));
        clayVeinsInput.setModel(new SpinnerNumberModel(0, 0, 5, 1));
        ironVeinsInput.setModel(new SpinnerNumberModel(0, 0, 7, 1));
        copperVeinsInput.setModel(new SpinnerNumberModel(0, 0, 8, 1));
        copperVeinsInput.setModel(new SpinnerNumberModel(0, 0, 10, 1));
        tinVeinsInput.setModel(new SpinnerNumberModel(0, 0, 6, 1));
        crudeVeinsInput.setModel(new SpinnerNumberModel(0, 0, 2, 1));
        totalVeinsInput.setModel(new SpinnerNumberModel(0, 0, 40, 1));

        start.addActionListener(e -> new Thread(() -> {
            guiPanel.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            double tries = 0;
            Layer l;
            Generator g;

            do {
                tries++;
                l = new Layer(0, 64, 64);
                g = new Generator(hash(randomString()));
                g.generate(l);
                if (clay2by2sCheckbox.isSelected() || dirt2by2sCheckbox.isSelected() || iron2by2sCheckbox.isSelected() || copper2by2sCheckbox.isSelected() || coal2by2sCheckbox.isSelected()
                        || tin2by2sCheckbox.isSelected() || crude2by2sCheckbox.isSelected() || total2by2sCheckbox.isSelected()) {
                    l.check2by2s();
                }
                triesLabel.setText(Double.toString(tries));
                //currentSeed.setText(Long.toString(g.getSeed()));
            } while (run && !(l.totalOreCount >= (totalCountRadio.isSelected() ? (int) totalCountInput.getValue() : 0) &&
                    l.totalVeinCount >= (totalVeinsRadio.isSelected() ? (int) totalVeinsInput.getValue() : 0) &&
                    l.total2by2s >= (total2by2sCheckbox.isSelected() ? (int) total2by2sInput.getValue() : 0) &&
                    l.crudeCount >= (crudeCountRadio.isSelected() ? (int) crudeCountInput.getValue() : 0) &&
                    l.crudeVeinCount >= (crudeVeinsRadio.isSelected() ? (int) crudeVeinsInput.getValue() : 0) &&
                    l.crude2by2s >= (crude2by2sCheckbox.isSelected() ? (int) crude2by2sInput.getValue() : 0) &&
                    l.tinCount >= (tinCountRadio.isSelected() ? (int) tinCountInput.getValue() : 0) &&
                    l.tinVeinCount >= (tinVeinsRadio.isSelected() ? (int) tinVeinsInput.getValue() : 0) &&
                    l.tin2by2s >= (tin2by2sCheckbox.isSelected() ? (int) tin2by2sInput.getValue() : 0) &&
                    l.dirtCount >= (dirtCountRadio.isSelected() ? (int) dirtCountInput.getValue() : 0) &&
                    l.dirtVeinCount >= (dirtVeinsRadio.isSelected() ? (int) dirtVeinsInput.getValue() : 0) &&
                    l.dirt2by2s >= (dirt2by2sCheckbox.isSelected() ? (int) dirt2by2sInput.getValue() : 0) &&
                    l.clayCount >= (clayCountRadio.isSelected() ? (int) clayCountInput.getValue() : 0) &&
                    l.clayVeinCount >= (clayVeinsRadio.isSelected() ? (int) clayVeinsInput.getValue() : 0) &&
                    l.clay2by2s >= (clay2by2sCheckbox.isSelected() ? (int) clay2by2sInput.getValue() : 0) &&
                    l.ironCount >= (ironCountRadio.isSelected() ? (int) ironCountInput.getValue() : 0) &&
                    l.ironVeinCount >= (ironVeinsRadio.isSelected() ? (int) ironVeinsInput.getValue() : 0) &&
                    l.iron2by2s >= (iron2by2sCheckbox.isSelected() ? (int) iron2by2sInput.getValue() : 0) &&
                    l.copperCount >= (copperCountRadio.isSelected() ? (int) copperCountInput.getValue() : 0) &&
                    l.copperVeinCount >= (copperVeinsRadio.isSelected() ? (int) copperVeinsInput.getValue() : 0) &&
                    l.copper2by2s >= (copper2by2sCheckbox.isSelected() ? (int) copper2by2sInput.getValue() : 0) &&
                    l.coalCount >= (coalCountRadio.isSelected() ? (int) coalCountInput.getValue() : 0) &&
                    l.coalVeinCount >= (coalVeinsRadio.isSelected() ? (int) coalVeinsInput.getValue() : 0) &&
                    l.coal2by2s >= (coal2by2sCheckbox.isSelected() ? (int) coal2by2sInput.getValue() : 0)
            ));
            run = true;
            System.out.println(l);
            triesLabel.setText(String.valueOf(tries));
            currentSeed.setText(Long.toString(g.getSeed()));
            guiPanel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

            layerDisplayPanel.removeAll();
            layerDisplayPanel.repaint();
            final int size = 10;
            for (int y = l.data.length - 1; y >= 0; y--) {
                for (int x = 0; x < l.data[y].length; x++) {
                    TileType tt = l.data[y][x];
                    JLabel label = new JLabel(" ");
                    label.setOpaque(true);
                    label.setBackground(Color.decode(tt.color));
                    label.setBounds(size * x, size * Math.abs(y - 63), size, size);
                    layerDisplayPanel.add(label);
                }
            }
            layerDisplayPanel.repaint();
        }).start());
        stop.addActionListener(e -> run = false);
        currentSeed.addActionListener(e -> currentSeed.selectAll());
    }

    private static String randomString() {
        Random rand = new Random();
        StringBuilder ok = new StringBuilder();
        for (int i = 0; i < 19; i++) {
            ok.append(rand.nextInt((9) + 1));
        }
        return ok.toString();
    }

    public static void main(String[] args) {
        Gui gui = new Gui();
        gui.setSize(840, 725);
        gui.setVisible(true);
    }

    private long hash(String str) {
        long j = 1125899906842597L;
        int length = str.length();
        for (int i = 0; i < length; i++) {
            j = (j * 31) + ((long) str.charAt(i));
        }
        return j;
    }
}
