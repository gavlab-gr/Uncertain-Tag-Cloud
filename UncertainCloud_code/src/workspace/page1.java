package workspace;
/**
 *
 * @author Evi
 */
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

import javax.swing.UIManager.*;

import wordcloud.*;
import wordcloud.bg.*;
import wordcloud.font.scale.*;
import wordcloud.palette.*;
import java.awt.*;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;
import javax.swing.UIManager;


public class page1 extends javax.swing.JFrame {
    
    // Variables declaration                     
    private ButtonGroup ShapeGroup;
    private ButtonGroup CollisionGroup;
    private JButton backgroundBtn;
    private JButton letterBtn;
    private JButton wordListBtn;
    private JButton createBtn;
    private JComboBox<String> fontMenu;
    private JComboBox<String> numList;
    private JFrame jFrame1;
    private JLabel colorl;
    private JLabel fontl;
    private JLabel shapel;
    private JLabel sizel;
    private JLabel xLforSize;
    private JLabel collisionL;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenuBar jMenuBar1;
    private JPanel colorPanel;
    private JPanel fontPanel;
    private JPanel shapePanel;
    private JPanel sizePanel;
    private JPanel collisionPanel;
    private JRadioButton rbPixelPerf;
    private JRadioButton rbRectColis;
    private JRadioButton rbRect;
    private JRadioButton rbCir;
    private JTextField textF1size;
    private JTextField textF2size;
    
    private Color colorChoiceB = new Color(156,0,56);
    private Color colorChoiceL = new Color(153,247,143);
    private String colorBackgroundHEX = "#666666";
    private String colorLetterHEX = "#99F78F";
    private JFileChooser fc = new JFileChooser();
    private JTextArea log;
    
    static private final String newline = "\n";
    private WordCloud wordCloud = new WordCloud(1024, 900, CollisionMode.PIXEL_PERFECT);
      
    private wordList wl;
    private AboutWindow aw;
    private popUpImage pu;
    // End of variables declaration 
    
    public page1() {
        initComponents();
    }
                       
    private void initComponents() {
        try{
           for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
           }
        }catch(Exception e){
             e.printStackTrace();
        }
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon13.png")));
        jFrame1 = new JFrame();
        ShapeGroup = new ButtonGroup();
        colorPanel = new JPanel();
        colorl = new JLabel();
        backgroundBtn = new JButton();
        letterBtn = new JButton();
        shapePanel = new JPanel();
        rbRect = new JRadioButton();
        shapel = new JLabel();
        rbCir = new JRadioButton();
        fontPanel = new JPanel();
        fontl = new JLabel();
        fontMenu = new JComboBox<>();
        numList = new JComboBox<>();
        sizePanel = new JPanel();
        sizel = new JLabel();
        wordListBtn = new JButton();
        createBtn = new JButton();
        jMenuBar1 = new JMenuBar();
        fileMenu = new JMenu();
        helpMenu = new JMenu();
        xLforSize = new JLabel();
        collisionL = new JLabel();
        collisionPanel = new JPanel();
        rbPixelPerf = new JRadioButton();
        CollisionGroup = new ButtonGroup();
        textF1size = new JTextField(5);
        textF2size = new JTextField(5);
        rbRectColis = new JRadioButton();
        
        wl = new wordList();
        aw = new AboutWindow();
        pu = new popUpImage();
        
        log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);

        Font font1 = new Font("Segoe Print", Font.BOLD, 13);
        Font font = new Font("Comic Sans MS", Font.PLAIN, 13);
        //Font font = new Font("Vernada", Font.PLAIN, 13);
        
        setSize(570, 470);
        setLocationRelativeTo(null);
        setTitle("UncertainCloud - Create a new tag cloud!");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        colorl.setText("Color - Choose a color");
        colorl.setFont(font);

        backgroundBtn.setText("Background");
        backgroundBtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Color initialBackground = backgroundBtn.getBackground();
            colorChoiceB = JColorChooser.showDialog(null, "Background Color",initialBackground);
            if (colorChoiceB != null) {
              backgroundBtn.setBackground(colorChoiceB);
              colorBackgroundHEX = toHex(colorChoiceB.getRed(),colorChoiceB.getGreen(),colorChoiceB.getBlue());
            }
          }
        });

        letterBtn.setText("Letters");
        letterBtn.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent actionEvent) {
            Color initialBackground = letterBtn.getBackground();
            colorChoiceL = JColorChooser.showDialog(null, "Letter Color",initialBackground);
            if (colorChoiceL != null) {
              letterBtn.setBackground(colorChoiceL);
              colorLetterHEX = toHex(colorChoiceL.getRed(),colorChoiceL.getGreen(),colorChoiceL.getBlue());
            }
          }
        });
        colorPanel.setBackground(new Color(238,238,238));
        GroupLayout jPanel1Layout = new GroupLayout(colorPanel);
        colorPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(colorl)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(backgroundBtn)
                .addGap(18, 18, 18)
                .addComponent(letterBtn)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(colorl)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(backgroundBtn)
                    .addComponent(letterBtn))
                .addGap(0, 31, Short.MAX_VALUE))
        );

        

        shapel.setText("Shape");
        shapel.setFont(font);
        
        ShapeGroup.add(rbRect);
        rbRect.setText("Rectangle");
        rbRect.setSelected(true);
        ShapeGroup.add(rbCir);
        rbCir.setText("Circle");

        shapePanel.setBackground(new Color(238,238,238));
        GroupLayout jPanel3Layout = new GroupLayout(shapePanel);
        shapePanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rbRect)
                .addGap(18, 18, 18)
                .addComponent(rbCir)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(shapel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(shapel)
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rbRect)
                    .addComponent(rbCir))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fontl.setText("Font - Choose the font");
        fontl.setFont(font);
        fontMenu.setModel(new DefaultComboBoxModel<>(new String[] { "Linear", "Sqrt" }));
        numList.setEditable(true);
        numList.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6",
                                                    "7", "8", "9", "10", "11", "12", "13", "14",
                                                    "15", "16", "17", "18", "19", "20" }));
        numList.setSelectedItem("10");

        fontPanel.setBackground(new Color(238,238,238));
        GroupLayout fontPanelLayout = new GroupLayout(fontPanel);
        fontPanel.setLayout(fontPanelLayout);
        fontPanelLayout.setHorizontalGroup(
            fontPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fontPanelLayout.createSequentialGroup()
                .addComponent(fontl)
                .addGap(0, 111, Short.MAX_VALUE))
            .addGroup(fontPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(fontMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(numList, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        fontPanelLayout.setVerticalGroup(
            fontPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fontPanelLayout.createSequentialGroup()
                .addComponent(fontl)
                .addGap(29, 29, 29)
                .addGroup(fontPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(fontMenu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(numList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(0, 33, Short.MAX_VALUE))
        );


        sizel.setText("Size");
        sizel.setFont(font);
        textF1size.setText("1024");        
        xLforSize.setText("x");
        textF2size.setText("700");

        sizePanel.setBackground(new Color(238,238,238));
        GroupLayout jPanel4Layout = new GroupLayout(sizePanel);
        sizePanel.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(sizel)
                .addGap(0, 166, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(textF1size, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(xLforSize)
                .addGap(8, 8, 8)
                .addComponent(textF2size, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(sizel)
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(textF1size, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(xLforSize)
                    .addComponent(textF2size, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        wordListBtn.setText("Word List");
        wordListBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               wl.setVisible(true);
            }
        });

        collisionL.setText("Collision Mode");
        collisionL.setFont(font);

        rbPixelPerf.setText("Pixel Perfect");
        rbPixelPerf.setSelected(true);
        rbRectColis.setText("Rectangle");
        CollisionGroup.add(rbPixelPerf);
        CollisionGroup.add(rbRectColis);
        
        collisionPanel.setBackground(new Color(238,238,238));
        GroupLayout jPanel5Layout = new GroupLayout(collisionPanel);
        collisionPanel.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(collisionL)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(rbPixelPerf)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rbRectColis)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(collisionL)
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPixelPerf, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbRectColis))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                if (fc.showSaveDialog(createBtn) == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    //This is where a real application would save the file.
                    log.append("Saving: " + file.getName() + "." + newline);
                    if(rbRect.isSelected()){
                        collisionCallR();
                    }else if(rbCir.isSelected()){
                        collisionCallC();
                    }
                    wordCloud.setPadding(2);
                    shapeCall();
                    colorCall();
                    fontCall();
                    wordCloud.build(wl.getFinalWordFrequencies());
                    wordCloud.writeToFile(file.getAbsoluteFile() + "\\NEW.png");
                    //wordCloud.writeToFile("out2.png");
                    
                    System.out.println("Create!");
                    
                    ImageIcon image = new ImageIcon(file.getAbsoluteFile() + "\\NEW.png");
                    pu.setImage(image);
                    pu.call();
                        
                    
                }else {
                    log.append("Save command cancelled by user." + newline);
                }
                log.setCaretPosition(log.getDocument().getLength());
            }
        });

        fileMenu.setText("File");
        JMenuItem exitIt = new JMenuItem("Exit");
        exitIt.addActionListener(new exitApp());
        fileMenu.add(exitIt);
        jMenuBar1.add(fileMenu);

        jMenuBar1.add(Box.createHorizontalGlue());
        helpMenu.setText("Help");
        JMenuItem aboutIt = new JMenuItem("About");
        aboutIt.addActionListener(new aboutApp());
        helpMenu.add(aboutIt);
        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addComponent(collisionPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(colorPanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(shapePanel, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(fontPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(sizePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(374, 374, 374)
                        .addComponent(wordListBtn)))
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(createBtn, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                .addGap(262, 262, 262))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(fontPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(sizePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(shapePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(collisionPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(createBtn)
                .addGap(27, 27, 27))
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(wordListBtn)
                .addGap(106, 106, 106))
        );

    }  
    
    private static class exitApp implements ActionListener {
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }

    
    private class aboutApp implements ActionListener {
        public void actionPerformed(ActionEvent e){
            aw.setVisible(true);
        }
    }  
    
    //Converting RGB to HEX
    public static String toHex(int r, int g, int b) {
        return "#"+toBrowserHexValue(r) + toBrowserHexValue(g) + toBrowserHexValue(b);
    }

    private static String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString().toUpperCase();
    }
    
    private void fontCall(){
        String s = (String) fontMenu.getSelectedItem();
        String w = (String) numList.getSelectedItem();
        int max = Integer.parseInt(w);
        int min=0;
        switch (max) {
            case 1:
                min = 5;
                max = 10;
                break;
            case 2: case 3: case 4: case 5:
            case 6: case 7: case 8: case 9:
               min = 5;
               max += 10;
               break;
            case 10:
                min = 10;
                max += 10;
            case 11: case 12: case 13: case 14: case 15: 
            case 16: case 17: case 18: case 19: case 20: 
                min = 12;
                max += 10; 
            default:
                min = 14;
                max += 10;
                break;
        }
       wordCloud.setFontScalar(new LinearFontScalar(min+8, max+10));
        switch (s) {
            case "Sqrt":
                wordCloud.setFontScalar(new SqrtFontScalar(min, max+10));
                break;
           }
    }
    
    private void collisionCallR(){
        int a = Integer.parseInt(textF1size.getText().trim());
        int b = Integer.parseInt(textF2size.getText().trim());
        if(rbPixelPerf.isSelected()){
            wordCloud = new WordCloud(a, b, CollisionMode.PIXEL_PERFECT);
        }else if(rbRectColis.isSelected()){
            wordCloud = new WordCloud(a, b, CollisionMode.RECTANGLE);
        }
        
    }
    private void collisionCallC(){
        int a = Integer.parseInt(textF1size.getText().trim());
        int b = Integer.parseInt(textF2size.getText().trim());
        if(a<b){
            if(rbPixelPerf.isSelected()){
            wordCloud = new WordCloud(a, a, CollisionMode.PIXEL_PERFECT);
            }else if(rbRectColis.isSelected()){
                wordCloud = new WordCloud(a, a, CollisionMode.RECTANGLE);
            }
        }else if(a>b){
            if(rbPixelPerf.isSelected()){
            wordCloud = new WordCloud(b, b, CollisionMode.PIXEL_PERFECT);
            }else if(rbRectColis.isSelected()){
                wordCloud = new WordCloud(b, b, CollisionMode.RECTANGLE);
            }
        }else{
            if(rbPixelPerf.isSelected()){
                wordCloud = new WordCloud(a, b, CollisionMode.PIXEL_PERFECT);
            }else if(rbRectColis.isSelected()){
                wordCloud = new WordCloud(a, b, CollisionMode.RECTANGLE);
            }
        }
        
    }
    private void colorCall(){
       wordCloud.setColorPalette(new ColorPalette(colorChoiceL));
       //wordCloud.setColorPalette(new buildRandomColorPalette(20));
       wordCloud.setBackgroundColor(colorChoiceB);
       // wordCloud.setColorPalette(new ColorPalette(colorChoiceL));
    }
    private void shapeCall(){
        int a = Integer.parseInt(textF1size.getText().trim());
        int b = Integer.parseInt(textF2size.getText().trim());

        if (b<a){
            if(rbCir.isSelected()){
                wordCloud.setBackground(new CircleBackground(b/2));

            }else if(rbRect.isSelected()){
                wordCloud.setBackground(new RectangleBackground(a, b));
            } 
        }else if (a<b){
            if(rbCir.isSelected()){
                wordCloud.setBackground(new CircleBackground(a/2));

            }else if(rbRect.isSelected()){
                wordCloud.setBackground(new RectangleBackground(a, b));
            } 
        }else{
            if(rbCir.isSelected()){
                wordCloud.setBackground(new CircleBackground(b/2));

            }else if(rbRect.isSelected()){
                wordCloud.setBackground(new RectangleBackground(a, b));
            } 
        }
    }
    
}
