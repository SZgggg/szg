package GUI.swing;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PayBill extends JFrame implements ActionListener{
    JPanel mainPanel = new JPanel();
    JPanel lastRow = new JPanel();
    String[] peopleSave = {"张研","庆航","惠惠","争光","刺猬","小应","付波","萌萌","景宜","鉴锋"};
    String[] functionSave = {"姓名","共付款","个人账单","转给/金额","转给/金额","转给/金额"};
    String[] itemSave = {"吃饭","打车","KTV","零食"};

    int peopleNum = peopleSave.length;
    int functionNum = functionSave.length;
    int itemNum = itemSave.length;
    int firstRowNum = itemNum + functionNum;
//    JButton[][] name = new JButton[peopleNum][itemNum];
    JButton[] firstRow = new JButton[firstRowNum];
    JButton[] people = new JButton[peopleNum];
    JButton subSumButton = new JButton("小计");
    JButton sum = new JButton("总计");
    JTextField sumBill = new JTextField("0");
    
    JTextField [] peoplePaid = new JTextField[peopleNum];
    JTextField [] peopleBill = new JTextField[peopleNum];
    JButton[] toName1 = new JButton[peopleNum];
    JTextField[] toNum1 = new JTextField[peopleNum];
    JButton[] toName2 = new JButton[peopleNum];
    JTextField[] toNum2 = new JTextField[peopleNum];
    JButton[] toName3 = new JButton[peopleNum];
    JTextField[] toNum3 = new JTextField[peopleNum];
    
    JCheckBox[][] itemSelect  = new JCheckBox[peopleNum][itemNum];
    JTextField[][] itemField = new JTextField[peopleNum][itemNum];

    JTextField[] subSum = new JTextField[itemNum];
    JButton caculate = new JButton("Caculate");
    JButton reset = new JButton("Reset");
    
    DecimalFormat df = new DecimalFormat("##0.00");

    public PayBill(){
        super("活动账单");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,600);
        BorderLayout totalLayout = new BorderLayout();
        setLayout(totalLayout);
        GridBagLayout mainLayout = new GridBagLayout();
        mainPanel.setLayout(mainLayout);
        GridBagConstraints s = new GridBagConstraints();
        s.fill = GridBagConstraints.BOTH;

        for(int i = 0; i < firstRowNum; i ++){
            if(i < functionNum){
                firstRow[i] = new JButton(functionSave[i]);
            }
            else{
                firstRow[i] = new JButton(itemSave[i - functionNum]);
            }
            mainPanel.add(firstRow[i]);
            if(i == firstRowNum - 1) s.gridwidth = 0;
            else s.gridwidth = 2;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(firstRow[i], s);
        }
        for(int i = 0; i < peopleNum; i ++){
            people[i] = new JButton(peopleSave[i]);
            peoplePaid[i] = new JTextField("0",5);
            peopleBill[i] = new JTextField("0",5);
            toName1[i] = new JButton("");
            toNum1[i] = new JTextField("0",4);
            toName2[i] = new JButton("");
            toNum2[i] = new JTextField("0",4);
            toName3[i] = new JButton("");
            toNum3[i] = new JTextField("0",4);
            
            mainPanel.add(people[i]);
            mainPanel.add(peoplePaid[i]);
            mainPanel.add(peopleBill[i]);
            mainPanel.add(toName1[i]);
            mainPanel.add(toNum1[i]);
            mainPanel.add(toName2[i]);
            mainPanel.add(toNum2[i]);
            mainPanel.add(toName3[i]);
            mainPanel.add(toNum3[i]);
            
            s.gridwidth = 2;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(people[i], s);
            s.gridwidth = 2;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(peoplePaid[i], s);
            s.gridwidth = 2;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(peopleBill[i], s);
            s.gridwidth = 1;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(toName1[i], s);
            s.gridwidth = 1;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(toNum1[i], s);
            s.gridwidth = 1;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(toName2[i], s);
            s.gridwidth = 1;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(toNum2[i], s);
            s.gridwidth = 1;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(toName3[i], s);
            s.gridwidth = 1;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(toNum3[i], s);
            
            for(int j = 0; j < itemNum; j ++){
                itemSelect[i][j] = new JCheckBox("参加",true);
                itemField[i][j] = new JTextField("0",4);
                mainPanel.add(itemSelect[i][j]);
                mainPanel.add(itemField[i][j]);

                s.gridwidth = 1;
                s.weightx = 0;
                s.weighty = 0;
                mainLayout.setConstraints(itemSelect[i][j], s);
                if(j == itemNum - 1) s.gridwidth = 0;
                else
                    s.gridwidth = 1;
                s.weightx = 0;
                s.weighty = 0;
                mainLayout.setConstraints(itemField[i][j], s);
            }
            }
        mainPanel.add(sum);
        s.gridwidth = 2;
        s.weightx = 0;
        s.weighty = 0;
        mainLayout.setConstraints(sum, s);
        mainPanel.add(sumBill);
        mainLayout.setConstraints(sumBill, s);
        mainPanel.add(subSumButton);
        s.gridx = 10;
        s.gridwidth = 2;
        s.weightx = 0;
        s.weighty = 0;
        mainLayout.setConstraints(subSumButton, s);
        for(int j = 0; j < itemNum; j ++){
            subSum[j] = new JTextField("0",6);
            mainPanel.add(subSum[j]);
            s.gridx += 2;
            s.gridwidth = 2;
            s.weightx = 0;
            s.weighty = 0;
            mainLayout.setConstraints(subSum[j], s);
        }
        
        FlowLayout lastLayout = new FlowLayout(FlowLayout.CENTER,20,40);
        lastRow.setLayout(lastLayout);
        lastRow.add(caculate);
        lastRow.add(reset);
        
        add(mainPanel,BorderLayout.CENTER);
        add(lastRow,BorderLayout.SOUTH);

        setVisible(true);
        
        caculate.addActionListener(this);
        reset.addActionListener(this);
        
    }
    
    void initial(){
        for(int i = 0; i < peopleNum; i ++){
            peoplePaid[i].setText("0");
            peopleBill[i].setText("0");
            toName1[i].setText("");
            toName2[i].setText("");
            toNum1[i].setText("0");
            toNum2[i].setText("0");
            toNum3[i].setText("0");
            toNum3[i].setText("0");            
            for(int j = 0; j < itemNum; j ++){
            itemSelect[i][j].setSelected(true);
            itemField[i][j].setText("0");

        }
    }
    }
    void caculateItemBill(int[] numCount){
        int num = 0;
        float sum = 0, subsum = 0;
        for(int j = 0; j < itemNum; j ++){
            subsum = 0;
            num = 0;
            for(int i = 0; i < peopleNum; i ++){
                if(itemSelect[i][j].isSelected()) 
                {
                    num += 1;
                    subsum += Float.parseFloat(itemField[i][j].getText());
            }
            }
        subSum[j].setText("" + df.format(subsum));
        sum += subsum;
        numCount[j] = num;
        }
        sumBill.setText("" + df.format(sum));
    }
    void caculatePersonBill(){
        int[] numCaculated = new int[itemNum];
        caculateItemBill(numCaculated);
        float  average = 0;
        float sum = 0;
        for(int i = 0; i < peopleNum; i ++){
            for(int j = 0; j < itemNum; j ++){
                if(itemSelect[i][j].isSelected()){
                    sum += Float.parseFloat(itemField[i][j].getText());
                    average += Float.parseFloat(subSum[j].getText()) / numCaculated[j];
                }
            }
            peoplePaid[i].setText("" + df.format(sum));
            peopleBill[i].setText("" + df.format(average));
            sum = 0;
            average = 0;
        }    
    }
    
    void write(int peopleFlag, int toFlag, String peopleName, float moneyNum){
        switch(toFlag){
        case(1) : {
            toName1[peopleFlag].setText(peopleName);
            toNum1[peopleFlag].setText("" + df.format(moneyNum));
            break;
        }
        case(2) : {
            toName2[peopleFlag].setText(peopleName);
            toNum2[peopleFlag].setText("" + df.format(moneyNum));
            break;
        }
        case(3) : {
            toName3[peopleFlag].setText(peopleName);
            toNum3[peopleFlag].setText("" + df.format(moneyNum));
            break;
        }        
    }
    }
    void toPeople(){
        float maxPaid = Float.parseFloat(peoplePaid[0].getText());
        int maxPaidFlag = 0;
        for(int i = 1; i < peopleNum; i ++){
            float temp = Float.parseFloat(peoplePaid[i].getText());
            if(temp > maxPaid){
                maxPaid = temp;
                maxPaidFlag = i;
            }
        }
        int countFlag = 0;
        for(int i = 0; i < peopleNum; i ++){
            if(i == maxPaidFlag) 
                 continue;
            else{
                float tempBill = Float.parseFloat(peopleBill[i].getText());
                float tempPaid = Float.parseFloat(peoplePaid[i].getText());
                if(tempBill > tempPaid){
                    write(i, 1, peopleSave[maxPaidFlag], (tempBill - tempPaid));
                }
                else if(tempBill != 0){
                    countFlag ++;
                    write(maxPaidFlag, countFlag, peopleSave[i], (tempPaid - tempBill));
            }
            }
        }
//        if(countFlag == 0){
//            write(maxPaidFlag, 1, "", 0);
//        }
    }
        public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        if(command.equals("Caculate")){
        caculatePersonBill();
        toPeople();
        }
        if(command.equals("Reset")){
            initial();
        }
    }
    
    
     private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception exc) {
            // ignore error
        }
    }
     
     public static void main(String[] args) {
        PayBill.setLookAndFeel();
        PayBill newBill = new PayBill();

    }
}