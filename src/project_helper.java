import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class project_helper implements ActionListener{
    JLabel balanceLabel = new JLabel();
    JTextField balanceTextF=new JTextField();
    JLabel typLabel = new JLabel();
    JTextField typTextF=new JTextField();
    JLabel interestLabel = new JLabel();
    JTextField interestTextF=new JTextField();
    JLabel monthsLabel=new JLabel();
    JTextField monthsTextF=new JTextField();
    JLabel vznosLabel=new JLabel();
    JTextField vznosTextF=new JTextField();
    JLabel paymentLabel=new JLabel();
    JTextField paymentTextF=new JTextField();
    Font myFont=new Font("Arial",Font.PLAIN,16);
    JButton computeButton=new JButton();
    JButton newLoanButton=new JButton();
    JButton monthsBut=new JButton();
    JButton paymentBut=new JButton();
    JButton zpButton=new JButton();
    JButton rezButton=new JButton();
    JLabel uslLabel=new JLabel();
    JTextArea uslTA=new JTextArea();
    JLabel analysisLabel=new JLabel();
    JTextArea analysisTA=new JTextArea();
    JButton exitBut=new JButton();
    JLabel zpLabel=new JLabel();
    JTextField zpTextF=new JTextField();
    JFrame jf=new JFrame("Кредитный помощник");
    ImageIcon myIcon=new ImageIcon("D:\\фото\\foto.png");
    ImageIcon myIcon1=new ImageIcon("D:\\фото\\foto1.png");
    ImageIcon myIcon2=new ImageIcon("D:\\фото\\foto1.png");
    JLabel forfoto=new JLabel(myIcon);
    JLabel forfoto1=new JLabel(myIcon1);
    JLabel forfoto2=new JLabel(myIcon2);
    JLabel texLab=new JLabel();
    String[] items = {
            "Выберете тип кредита",
            "Потребительский кредит",
            "Автокредит",
            "Ипотечный кредит"
    };
    JComboBox comboBox = new JComboBox(items);
    public static void main(String[] args){
        //new project_Helper().show();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new project_helper();
            }
        });
    }
    public project_helper(){
        jf.getContentPane().setBackground(Color.decode("#FFFAF0"));
        jf.getContentPane().setLayout(new GridBagLayout());
        jf.setSize(1650,650);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        forfoto.setFont(myFont);
        GridBagConstraints gridCons;
        gridCons=new GridBagConstraints();
        gridCons.gridx=3;
        gridCons.gridy=0;
        gridCons.insets=new Insets(10,0,0,50);
        jf.getContentPane().add(forfoto,gridCons);

        forfoto1.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=0;
        gridCons.insets=new Insets(10,0,0,0);
        jf.getContentPane().add(forfoto1,gridCons);

        forfoto2.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=4;
        gridCons.gridy=0;
        gridCons.insets=new Insets(10,0,0,165);
        jf.getContentPane().add(forfoto2,gridCons);

        typLabel.setText("Тип кредита");
        typLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=1;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(typLabel,gridCons);
        typTextF.setPreferredSize(new Dimension(100,25));
        typTextF.setFont(myFont);

        comboBox.setEditable(true);
        comboBox.setFont(myFont);
        comboBox.setBackground(Color.decode("#FFEFD5"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=1;
        gridCons.insets=new Insets(10,10,0,10);
        jf.getContentPane().add(comboBox,gridCons);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vyborActionPerformed(e);
            }
        });

        balanceLabel.setText("Сумма кредита");
        balanceLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=2;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(balanceLabel,gridCons);
        balanceTextF.setPreferredSize(new Dimension(100,25));
        balanceTextF.setFont(myFont);
        balanceTextF.setBackground(Color.decode("#FFEFD5"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=2;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(balanceTextF,gridCons);

        texLab.setText("Для подробного анализа укажите Вашу з/п и нажмите кнопку *Результат анализа по з/п*");
        balanceLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=4;
        gridCons.gridy=7;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(texLab,gridCons);

        interestLabel.setText("Процентная ставка");
        interestLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=3;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(interestLabel,gridCons);
        interestTextF.setPreferredSize(new Dimension(100,25));
        interestTextF.setHorizontalAlignment(SwingConstants.RIGHT);
        interestTextF.setFont(myFont);
        interestTextF.setBackground(Color.decode("#FFEFD5"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=3;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(interestTextF,gridCons);

        monthsLabel.setText("Число месяцев кредита");
        monthsLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=4;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(monthsLabel,gridCons);
        monthsTextF.setPreferredSize(new Dimension(100,25));
        monthsTextF.setHorizontalAlignment(SwingConstants.RIGHT);
        monthsTextF.setFont(myFont);
        monthsTextF.setBackground(Color.decode("#FFEFD5"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=4;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(monthsTextF,gridCons);

        vznosLabel.setText("Первоначальный взнос");
        vznosLabel.setFont(myFont);
        vznosLabel.setEnabled(false);
        vznosTextF.setEnabled(false);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=5;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(vznosLabel,gridCons);
        vznosTextF.setPreferredSize(new Dimension(100,25));
        vznosTextF.setHorizontalAlignment(SwingConstants.RIGHT);
        vznosTextF.setFont(myFont);
        vznosTextF.setBackground(Color.decode("#FFEFD5"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=5;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(vznosTextF,gridCons);

        zpLabel.setText("Ваша з/п");
        zpLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=6;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(zpLabel,gridCons);
        zpTextF.setPreferredSize(new Dimension(100,25));
        zpTextF.setHorizontalAlignment(SwingConstants.RIGHT);
        zpTextF.setFont(myFont);
        zpTextF.setBackground(Color.decode("#FFEFD5"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=6;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(zpTextF,gridCons);

        paymentLabel.setText("Ежемесячный платеж");
        paymentLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=7;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(10,10,0,0);
        jf.getContentPane().add(paymentLabel,gridCons);
        paymentTextF.setPreferredSize(new Dimension(200,25));
        paymentTextF.setHorizontalAlignment(SwingConstants.RIGHT);
        paymentTextF.setFont(myFont);
        paymentTextF.setBackground(Color.decode("#FFEFD5"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=1;
        gridCons.gridy=7;
        gridCons.insets=new Insets(10,10,0,10);
        jf.getContentPane().add(paymentTextF,gridCons);

        monthsBut.setText("Срок");
        monthsBut.setBackground(Color.decode("#FFDAB9"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=2;
        gridCons.gridy=4;
        gridCons.insets=new Insets(10,0,0,10);
        jf.getContentPane().add(monthsBut,gridCons);
        monthsLabel.setEnabled(true);
        monthsTextF.setEnabled(true);
        monthsBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                monthsButActionPerformed(e);
            }

        });
        paymentBut.setText("Платеж");
        paymentBut.setBackground(Color.decode("#FFDAB9"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=2;
        gridCons.gridy=5;
        gridCons.insets=new Insets(10,0,0,0);
        jf.getContentPane().add(paymentBut,gridCons);
        monthsLabel.setEnabled(false);
        monthsTextF.setEnabled(false);
        paymentBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                paymentButActionPerformed(e);
            }
        });

        computeButton.setText("Рассчитать ежемесячный платеж");
        computeButton.setBackground(Color.decode("#98FB98"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=8;
        gridCons.gridwidth=2;
        gridCons.insets=new Insets(10,0,0,0);
        jf.getContentPane().add(computeButton,gridCons);
        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                computeButtonActionPerformed(e);
            }
        });

        zpButton.setText("Указать з/п");
        zpButton.setBackground(Color.decode("#FFDAB9"));
        zpLabel.setEnabled(false);
        zpTextF.setEnabled(false);
        gridCons=new GridBagConstraints();
        gridCons.gridx=2;
        gridCons.gridy=8;
        //gridCons.gridwidth=2;
        gridCons.insets=new Insets(10,0,0,10);
        jf.getContentPane().add(zpButton,gridCons);
        zpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                zpButtonActionPerformed(e);
            }
        });

        rezButton.setText("Результат анализа по з/п");
        rezButton.setBackground(Color.decode("#98FB98"));
        zpLabel.setEnabled(false);
        zpTextF.setEnabled(false);
        gridCons=new GridBagConstraints();
        gridCons.gridx=4;
        gridCons.gridy=6;
        //gridCons.gridwidth=2;
        gridCons.insets=new Insets(10,0,0,0);
        jf.getContentPane().add(rezButton,gridCons);
        rezButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                rezButtonActionPerformed(e);
            }
        });

        newLoanButton.setText("Новый анализ кредита");
        newLoanButton.setEnabled(false);
        newLoanButton.setBackground(Color.decode("#F0FFF0"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=0;
        gridCons.gridy=9;
        gridCons.gridwidth=2;
        gridCons.insets=new Insets(10,0,10,0);
        jf.getContentPane().add(newLoanButton,gridCons);
        newLoanButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newLoanButtonActionPerformed(e);
            }
        });

        uslLabel.setText("Условия кредита");
        uslLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=3;
        gridCons.gridy=1;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(0,10,0,0);
        jf.getContentPane().add(uslLabel,gridCons);
        uslTA.setPreferredSize(new Dimension(320,150));
        uslTA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        uslTA.setFont(new Font("Courier New",Font.PLAIN,14));
        uslTA.setEditable(false);
        uslTA.setBackground(Color.decode("#FFEFD5"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=3;
        gridCons.gridy=2;
        gridCons.gridheight=4;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(0,10,0,10);
        jf.getContentPane().add(uslTA,gridCons);

        analysisLabel.setText("Результат анализа");
        analysisLabel.setFont(myFont);
        gridCons=new GridBagConstraints();
        gridCons.gridx=4;
        gridCons.gridy=1;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(0,10,0,0);
        jf.getContentPane().add(analysisLabel,gridCons);
        analysisTA.setPreferredSize(new Dimension(450,150));
        analysisTA.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        analysisTA.setFont(new Font("Courier New",Font.PLAIN,14));
        analysisTA.setEditable(false);
        analysisTA.setBackground(Color.decode("#FFEBCD"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=4;
        gridCons.gridy=2;
        gridCons.gridheight=4;
        gridCons.anchor=GridBagConstraints.WEST;
        gridCons.insets=new Insets(0,10,0,10);
        jf.getContentPane().add(analysisTA,gridCons);

        exitBut.setText("Выход");
        exitBut.setBackground(Color.decode("#FFDAB9"));
        gridCons=new GridBagConstraints();
        gridCons.gridx=5;
        gridCons.gridy=9;
        jf.getContentPane().add(exitBut,gridCons);
        exitBut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitButActionPerformed(e);
            }
        });
        jf.setVisible(true);
    }
    public void vyborActionPerformed(ActionEvent e) {
        String text="";
        if ((String)comboBox.getSelectedItem()==("Выберете тип кредита")){
            text="Выберете тип кредита";
            vznosTextF.setEnabled(false);
            vznosLabel.setEnabled(false);}
        if ((String)comboBox.getSelectedItem()==("Потребительский кредит")) {
            text = "Условия потребительского кредита:" + "\nПроцентная ставка зависит от срока" + "\nкредитования";
            vznosTextF.setEnabled(false);
            vznosLabel.setEnabled(false);
        }
        if ((String)comboBox.getSelectedItem()==("Автокредит")){
            text="Условия автокредита:"+"\nПроцентная ставка зависит от срока"+"\nкредитования";
            vznosTextF.setEnabled(true);
            vznosLabel.setEnabled(true);}
        if ((String)comboBox.getSelectedItem()==("Ипотечный кредит")) {
            text = "Условия ипотечного кредита:" + "\nПроцентная ставка не зависит" + "\nот срока кредитования";
            vznosTextF.setEnabled(true);
            vznosLabel.setEnabled(true);
        }
        uslTA.setText(text);

    }
    private void exitButActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void computeButtonActionPerformed(ActionEvent e){
        try {
            if (computeButton.getText().equals("Рассчитать ежемесячный платеж")) {
                if ((String) comboBox.getSelectedItem() == ("Потребительский кредит")) {
                    double ch1 = Double.parseDouble(balanceTextF.getText());
                    double ch2 = Double.parseDouble(monthsTextF.getText());
                    double ch3 = Double.parseDouble(interestTextF.getText());
                    double st_months = ch3 / (100 * 12);
                    double pl = ch1 * (st_months * (Math.pow((1 + st_months), ch2))) / ((Math.pow((1 + st_months), ch2)) - 1);
                    double scale=Math.pow(10,2);
                    double pr=Math.ceil(pl*scale)/scale;
                    paymentTextF.setText(Double.toString(pr));
                    String text="";
                    text="Ежемесячный платеж составит: "+ paymentTextF.getText()+" рублей";
                    analysisTA.setText(text);
                    newLoanButton.setEnabled(true);

                }
                if ((String) comboBox.getSelectedItem() == ("Автокредит")) {
                    double ch1 = Double.parseDouble(balanceTextF.getText());
                    double ch2 = Double.parseDouble(monthsTextF.getText());
                    double ch3 = Double.parseDouble(interestTextF.getText());
                    double per_vzn = Double.parseDouble(vznosTextF.getText());
                    double s = ch1 - per_vzn;
                    double st_months = ch3 / (100 * 12);
                    double pl = s * (st_months * (Math.pow((1 + st_months), ch2))) / ((Math.pow((1 + st_months), ch2)) - 1);
                    double scale=Math.pow(10,2);
                    double pr=Math.ceil(pl*scale)/scale;
                    paymentTextF.setText(Double.toString(pr));
                    String text="";
                    text="Ежемесячный платеж составит: "+ paymentTextF.getText()+" рублей";
                    analysisTA.setText(text);
                    newLoanButton.setEnabled(true);

                }
                if ((String) comboBox.getSelectedItem() == ("Ипотечный кредит")) {
                    double ch1 = Double.parseDouble(balanceTextF.getText());
                    double ch2 = Double.parseDouble(monthsTextF.getText());
                    double ch3 = Double.parseDouble(interestTextF.getText());
                    double per_vzn = Double.parseDouble(vznosTextF.getText());
                    double s = ch1 - per_vzn;
                    double st_months = ch3 / (100 * 12);
                    double pl = s * (st_months * (Math.pow((1 + st_months), ch2))) / ((Math.pow((1 + st_months), ch2)) - 1);
                    double scale=Math.pow(10,2);
                    double pr=Math.ceil(pl*scale)/scale;
                    paymentTextF.setText(Double.toString(pr));
                    String text="";
                    text="Ежемесячный платеж составит: "+ paymentTextF.getText()+" рублей";
                    analysisTA.setText(text);
                    newLoanButton.setEnabled(true);

                }
                JOptionPane.showMessageDialog(jf,"Проверьте, что вы ввели именно количесвто месяцев, а не количество лет!");
            }
            if (computeButton.getText().equals("Рассчитать число месяцев кредита")) {
                monthsLabel.setEnabled(true);
                monthsTextF.setEnabled(true);
                int i;
                int S=0;

                double perc=0;
                for (i=1;i<1000;i++) {
                    S = i;
                    double sum;
                    double ch3 = Double.parseDouble(interestTextF.getText());
                    double pl = Double.parseDouble(paymentTextF.getText());
                    double st_months = ch3 / (100 * 12);
                    double pl1 = (st_months * (Math.pow((1 + st_months), S))) / ((Math.pow((1 + st_months), S)) - 1);
                    double ch1 = Double.parseDouble(balanceTextF.getText());
                    double result;
                    if ((String) comboBox.getSelectedItem() == ("Потребительский кредит")) {
                        if (pl >= ch1 * pl1) {
                            sum = ch1 * pl1;
                            result = sum * S;
                            perc = result - ch1;
                            break;
                        }
                        else continue;
                    }
                    if (((String)comboBox.getSelectedItem()==("Автокредит"))|
                            ((String)comboBox.getSelectedItem()==("Ипотечный кредит"))){
                        double mes;
                        double per_vzn=Double.parseDouble(vznosTextF.getText());
                        mes=ch1-per_vzn;
                        if (pl >= mes * pl1) {
                            sum = mes * pl1;
                            result = sum * S;
                            perc = result - mes;
                            break;
                        }
                        else continue;
                    }
                }
                newLoanButton.setEnabled(true);
                double pr = Math.ceil(S);
                monthsTextF.setText(Double.toString(pr));
                String text = "";
                text = "Число месяцев кредита составит: " + monthsTextF.getText() + " месяцев" + "\n" +
                        "Сумма переплаты: " + String.format("%.2f", perc);
                analysisTA.setText(text);
                newLoanButton.setEnabled(true);
            }
        }catch (NumberFormatException exc){
            System.out.println("Error");}
        if ((balanceTextF.getText( ).matches("[a-zA-Zа-яА-Я]+"))||(balanceTextF.getText().matches("[a-zA-Zа-яА-Я0-9]+"))
                &(!(balanceTextF.getText()).matches("[0-9]+"))){
            JOptionPane.showMessageDialog(jf,"В поле *Сумма кредита* были введены недопустимые значения!");
            newLoanButton.setEnabled(true);}
        if ((interestTextF.getText().matches("[a-zA-Zа-яА-Я]+"))||(interestTextF.getText().matches("[a-zA-Zа-яА-Я0-9]+"))
                &(!(interestTextF.getText()).matches("[0-9]+"))){
            JOptionPane.showMessageDialog(jf,"В поле *Процентная ставка* были введены недопустимые значения!");
            newLoanButton.setEnabled(true);}
        if ((monthsTextF.getText().matches("[a-zA-Zа-яА-Я]+"))||(monthsTextF.getText().matches("[a-zA-Zа-яА-Я0-9]+"))
                &(!(monthsTextF.getText()).matches("[0-9]+"))){
            JOptionPane.showMessageDialog(jf,"В поле *Число месяцев кредита* были введены недопустимые значения!");
            newLoanButton.setEnabled(true);}
        if ((vznosTextF.getText().matches("[a-zA-Zа-яА-Я]+"))||(vznosTextF.getText().matches("[a-zA-Zа-яА-Я0-9]+"))
                &(!(vznosTextF.getText()).matches("[0-9]+"))){
            JOptionPane.showMessageDialog(jf,"В поле *Первоначальный взнос* были введены недопустимые значения!");
            newLoanButton.setEnabled(true);}
        if ((zpTextF.getText().matches("[a-zA-Zа-яА-Я]+"))||(zpTextF.getText().matches("[a-zA-Zа-яА-Я0-9]+"))
                &(!(zpTextF.getText()).matches("[0-9]+"))){
            JOptionPane.showMessageDialog(jf,"В поле *Ваша з/п* были введены недопустимые значения!");
            zpTextF.setText("");
            newLoanButton.setEnabled(true);}
    }
    public void actionPerformed(ActionEvent ae){
    }
    private void newLoanButtonActionPerformed(ActionEvent e){
        monthsTextF.setText("");
        paymentTextF.setText("");
        interestTextF.setText("");
        analysisTA.setText("");
        uslTA.setText("");
        vznosTextF.setText("");
        comboBox.setSelectedIndex(0);
        analysisTA.setBackground(Color.decode("#FFEBCD"));
        zpTextF.setText("");
        zpLabel.setEnabled(false);
        zpTextF.setEnabled(false);
        newLoanButton.setEnabled(false);
    }
    private void monthsButActionPerformed(ActionEvent e) {
        computeButton.setText("Рассчитать ежемесячный платеж");
        monthsLabel.setEnabled(true);
        monthsTextF.setEnabled(true);
    }
    private void paymentButActionPerformed(ActionEvent e) {
        monthsLabel.setEnabled(false);
        monthsTextF.setEnabled(false);
        computeButton.setText("Рассчитать число месяцев кредита");



    }
    private void zpButtonActionPerformed(ActionEvent e) {
        zpLabel.setEnabled(true);
        zpTextF.setEnabled(true);
    }
    private void rezButtonActionPerformed(ActionEvent e) {
        try {
            if (computeButton.getText().equals("Рассчитать ежемесячный платеж")) {
                if ((String) comboBox.getSelectedItem() == ("Потребительский кредит")) {
                    String text = "";
                    double ch1 = Double.parseDouble(balanceTextF.getText());
                    double ch2 = Double.parseDouble(monthsTextF.getText());
                    //double pr = Double.parseDouble(paymentTextF.getText());
                    double zp = Double.parseDouble(zpTextF.getText());
                    double sum_pl = Double.parseDouble(paymentTextF.getText()) * ch2;
                    if (Double.parseDouble(paymentTextF.getText()) < (0.2 * zp)) {
                        text = "\nБлагоприятные условия" + "\nдля кредита." + "\nМожно смело его брать!" +
                                "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - ch1);
                        analysisTA.setBackground(Color.decode("#00FF7F"));
                    } else if ((Double.parseDouble(paymentTextF.getText()) > (0.2 * zp)) &
                            (Double.parseDouble(paymentTextF.getText()) < (0.4 * zp))) {
                        text = "\nУдовлетворительные условия" + "\nдля кредита." + "\nМожете его брать, но рекомендуется" + "\nпересмотреть некоторые условия" +
                                "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - ch1);
                        analysisTA.setBackground(Color.decode("#FFE4B5"));
                    } else if ((Double.parseDouble(paymentTextF.getText()) > (0.4 * zp)) &
                            (Double.parseDouble(paymentTextF.getText()) < (0.8 * zp))) {
                        text = "\nНеудовлетворительные условия" + "\nдля кредита." + "\nБрать его не рекомендуется." + "\nВы не сможете его обслуживать!"
                                + "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - ch1);
                        analysisTA.setBackground(Color.decode("#FFA07A"));
                    } else if (Double.parseDouble(paymentTextF.getText()) > (0.8 * zp)) {
                        text = "\nОчень плохие условия" + "\nдля кредита." + "\nБрать его нельзя ни в коем случае!" +
                                "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - ch1);
                        analysisTA.setBackground(Color.decode("#FF6347"));
                    }
                    analysisTA.append(text);
                }
                if ((String) comboBox.getSelectedItem() == ("Автокредит")) {
                    String text = "";
                    double ch1 = Double.parseDouble(balanceTextF.getText());
                    double per_vzn = Double.parseDouble(vznosTextF.getText());
                    double pr = Double.parseDouble(paymentTextF.getText());
                    double zp = Double.parseDouble(zpTextF.getText());
                    double sum_pl = pr * Double.parseDouble(monthsTextF.getText());
                    double s = ch1 - per_vzn;
                    if (pr < (0.2 * zp)) {
                        text = "\nБлагоприятные условия" + "\nдля кредита." + "\nМожно смело его брать!" +
                                "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - s);
                        analysisTA.setBackground(Color.decode("#00FF7F"));
                    } else if ((pr > (0.2 * zp)) & (pr < (0.4 * zp))) {
                        text = "\nУдовлетворительные условия" + "\nдля кредита." + "\nМожете его брать, но рекомендуется" + "\nпересмотреть некоторые условия" +
                                "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - s);
                        analysisTA.setBackground(Color.decode("#FFE4B5"));
                    } else if ((pr > (0.4 * zp)) & (pr < (0.8 * zp))) {
                        text = "\nНеудовлетворительные условия" + "\nдля кредита." + "\nБрать его не рекомендуется." + "\nВы не сможете его обслуживать!"
                                + "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - s);
                        analysisTA.setBackground(Color.decode("#FFA07A"));
                    } else if (pr > (0.8 * zp)) {
                        text = "\nОчень плохие условия" + "\nдля кредита." + "\nБрать его нельзя ни в коем случае!" +
                                "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - s);
                        analysisTA.setBackground(Color.decode("#FF6347"));
                    }
                    analysisTA.append(text);
                }
                if ((String) comboBox.getSelectedItem() == ("Ипотечный кредит")) {
                    String text = "";
                    double pr = Double.parseDouble(paymentTextF.getText());
                    double zp = Double.parseDouble(zpTextF.getText());
                    double ch1 = Double.parseDouble(balanceTextF.getText());
                    double per_vzn = Double.parseDouble(vznosTextF.getText());
                    double s = ch1 - per_vzn;
                    double sum_pl = pr * Double.parseDouble(monthsTextF.getText());
                    if (pr < (0.2 * zp)) {
                        text = "\nБлагоприятные условия" + "\nдля кредита." + "\nМожно смело его брать!" +
                                "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - s);
                        analysisTA.setBackground(Color.decode("#00FF7F"));
                    } else if ((pr > (0.2 * zp)) & (pr < (0.4 * zp))) {
                        text = "\nУдовлетворительные условия" + "\nдля кредита." + "\nМожете его брать, но рекомендуется" + "\nпересмотреть некоторые условия" +
                                "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - s);
                        analysisTA.setBackground(Color.decode("#FFE4B5"));
                    } else if ((pr > (0.4 * zp)) & (pr < (0.8 * zp))) {
                        text = "\nНеудовлетворительные условия" + "\nдля кредита." + "\nБрать его не рекомендуется." + "\nВы не сможете его обслуживать!"
                                + "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - s);
                        analysisTA.setBackground(Color.decode("#FFA07A"));
                    } else if (pr > (0.8 * zp)) {
                        text = "\nОчень плохие условия" + "\nдля кредита." + "\nБрать его нельзя ни в коем случае!" +
                                "\nСумма переплаты составит: " + String.format("%.2f", sum_pl - s);
                        analysisTA.setBackground(Color.decode("#FF6347"));
                    }
                    analysisTA.append(text);
                }
            }
            if (computeButton.getText().equals("Рассчитать число месяцев кредита")) {
                if ((String) comboBox.getSelectedItem() == ("Потребительский кредит")) {
                    String text1 = "";
                    double ch1 = Double.parseDouble(balanceTextF.getText());
                    double zp = Double.parseDouble(zpTextF.getText());
                    double ch3 = Double.parseDouble(interestTextF.getText());
                    double m=Double.parseDouble(monthsTextF.getText());
                    double st_months = ch3 / (100 * 12);
                    double pl1 = ch1* (st_months * (Math.pow((1 + st_months),m))) / ((Math.pow((1 + st_months), m)) - 1);
                    if (pl1 <= (0.2 * zp)) {
                        text1 = "\nБлагоприятные условия для кредита." + "\nМожно смело его брать!"
                                +"\nПо рассчитанному сроку кредита комфортный" +
                                "\nежемесячный платеж составит: "+String.format("%.2f",pl1);
                        analysisTA.setBackground(Color.decode("#00FF7F"));
                    } else if ((pl1 > (0.2 * zp)) & (pl1 <= (0.4 * zp))) {
                        text1 = "\nУдовлетворительные условия для кредита." + "\nМожете его брать, но рекомендуется" +
                                "\nпересмотреть некоторые условия" +
                                "\nПо рассчитанному сроку кредита комфортный" +
                                "\nежемесячный платеж составит:" +String.format("%.2f",pl1);
                        analysisTA.setBackground(Color.decode("#FFE4B5"));
                    } else if ((pl1 > (0.4 * zp)) & (pl1 <= (0.8 * zp))) {
                        text1 = "\nНеудовлетворительные условия для кредита." +
                                "\nБрать его не рекомендуется." + "\nВы не сможете его обслуживать!"
                                + "\nПо рассчитанному сроку кредита комфортный" +
                                "\nежемесячный платеж составит: "+String.format("%.2f",pl1);
                        analysisTA.setBackground(Color.decode("#FFA07A"));
                    } else if (pl1 > (0.8 * zp)) {
                        text1 = "\nОчень плохие условия для кредита." + "\nБрать его нельзя ни в коем случае!" +
                                "\nПо рассчитанному сроку кредита комфортный" +
                                "\nежемесячный платеж составит: "+String.format("%.2f",pl1);
                        analysisTA.setBackground(Color.decode("#FF6347"));
                    }
                    analysisTA.append(text1);
                }
                if (((String) comboBox.getSelectedItem() == ("Автокредит"))|
                        (String) comboBox.getSelectedItem() == ("Ипотечный кредит")) {
                    double ch1 = Double.parseDouble(balanceTextF.getText());
                    String text = "";
                    double zp = Double.parseDouble(zpTextF.getText());
                    double ch3 = Double.parseDouble(interestTextF.getText());
                    double m=Double.parseDouble(monthsTextF.getText());
                    double st_months = ch3 / (100 * 12);
                    double pl1 = ch1*(st_months * (Math.pow((1 + st_months), m))) / ((Math.pow((1 + st_months), m)) - 1);
                    if (pl1 < (0.2 * zp)) {
                        text = "\nБлагоприятные условия для кредита." + "\nМожно смело его брать!" +
                                "\nПо рассчитанному сроку кредита комфортный" +
                                "\nежемесячный платеж составит: "+String.format("%.2f",pl1);

                        analysisTA.setBackground(Color.decode("#00FF7F"));
                    } else if ((pl1 > (0.2 * zp)) & (pl1 < (0.4 * zp))) {
                        text = "\nУдовлетворительные условия для кредита." + "\nМожете его брать, но рекомендуется"
                                + "\nпересмотреть некоторые условия" +
                                "\nПо рассчитанному сроку кредита комфортный" +
                                "\nежемесячный платеж составит: "+String.format("%.2f",pl1);

                        analysisTA.setBackground(Color.decode("#FFE4B5"));
                    } else if ((pl1 > (0.4 * zp)) & (pl1 < (0.8 * zp))) {
                        text = "\nНеудовлетворительные условия для кредита." + "\nБрать его не рекомендуется." + "\nВы не сможете его обслуживать!"
                                + "\nПо рассчитанному сроку кредита комфортный" +
                                "\nежемесячный платеж составит:"+String.format("%.2f",pl1);
                        analysisTA.setBackground(Color.decode("#FFA07A"));
                    } else if (pl1 > (0.8 * zp)) {
                        text = "\nОчень плохие условия для кредита." + "\nБрать его нельзя ни в коем случае!" +
                                "\nПо рассчитанному сроку кредита комфортный" +
                                "\nежемесячный платеж составит: "+String.format("%.2f",pl1);
                        analysisTA.setBackground(Color.decode("#FF6347"));
                    }
                    analysisTA.append(text);
                }
            }
        } catch (NumberFormatException exc){
            System.out.println("Error");
        }
        if ((zpTextF.getText().matches("[a-zA-Zа-яА-Я]+"))||(zpTextF.getText().matches("[a-zA-Zа-яА-Я0-9]+"))
                &(!(zpTextF.getText()).matches("[0-9]+"))){
            JOptionPane.showMessageDialog(jf,"В поле *Ваша з/п* были введены недопустимые значения!");
            zpTextF.setText("");
            newLoanButton.setEnabled(true);}
    }
}


