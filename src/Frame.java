import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Frame extends JFrame {
    private static final int Width=400;
    private static final int Height=320;
    private static final double PI=3.1415;

    Double SumFunc=0.0;//memory1 for functions
    Double SumCMemory=0.0;//memeory with recet
    Double SumVariable=0.0;//memory for memories


    private JTextField Text_X;
    private JTextField Text_Y;
    private JTextField Text_Z;

    private JTextField Result;
    private JTextField Mem1;
    private JTextField Mem2;
    private JTextField Mem3;

   private JButton CalcButt=new JButton("Calculate");
   private JButton ResetButt=new JButton("Recet fields");
   private JButton MemoryFormulaButton=new JButton("M");
    private JButton MemoryMCButton=new JButton("MC");
    private JButton MemoryVariableButton=new JButton("M+");


    private ButtonGroup RadioButtons=new ButtonGroup();
    private ButtonGroup VariableRadioButtons=new ButtonGroup();

    private Box boxFormulaType=Box.createHorizontalBox();
    private Box boxVariableRadio=Box.createHorizontalBox();

    private int variableId=1;
    private int formulaId=1;

    public Frame(){
        super("Calculator");
        setSize(Width,Height);
        Toolkit kit=Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width-Width)/2,(kit.getScreenSize().height-Height)/2);

        //checkboxVariable start
        AddVariableRadioButton("Mem1",1);
        AddVariableRadioButton("Mem2",2);
        AddVariableRadioButton("Mem3",3);
        VariableRadioButtons.setSelected(VariableRadioButtons.getElements().nextElement().getModel(),true);
        boxVariableRadio.add(Box.createHorizontalGlue());
        //checkboxVariable end

        //checkboxFormula start
        boxFormulaType.add(Box.createHorizontalGlue());
        AddRadioButton("Formula 1",1);
        AddRadioButton("Formula 2",2);
        RadioButtons.setSelected(RadioButtons.getElements().nextElement().getModel(),true);
        boxFormulaType.add(Box.createHorizontalGlue());
        //checkboxFormula end


        //x,y,z field to enter start
        JLabel Label_X=new JLabel("X:");
        Text_X=new JTextField("0",15);
        Text_X.setMaximumSize(Text_X.getPreferredSize());

        JLabel Label_Y=new JLabel("Y:");
        Text_Y=new JTextField("0",15);
        Text_Y.setMaximumSize(Text_Y.getPreferredSize());

        JLabel Label_Z=new JLabel("Z:");
        Text_Z=new JTextField("0",15);
        Text_Z.setMaximumSize(Text_Z.getPreferredSize());

        Box BoxVariables=Box.createHorizontalBox();

        BoxVariables.add(Box.createHorizontalGlue());

        BoxVariables.add(Label_X);
        BoxVariables.add(Box.createHorizontalStrut(10));
        BoxVariables.add(Text_X);

        BoxVariables.add(Box.createHorizontalStrut(100));

        BoxVariables.add(Label_Y);
        BoxVariables.add(Box.createHorizontalStrut(10));
        BoxVariables.add(Text_Y);

        BoxVariables.add(Box.createHorizontalStrut(100));

        BoxVariables.add(Label_Z);
        BoxVariables.add(Box.createHorizontalStrut(10));
        BoxVariables.add(Text_Z);
        // x,y,z field to enter end

        //Mem1,Mem2,Mem3 start
        JLabel Label_Mem1=new JLabel("Mem1:");
        Mem1=new JTextField("0",15);
        Mem1.setMaximumSize(Mem1.getPreferredSize());


        JLabel Label_Mem2=new JLabel("Mem2:");
        Mem2=new JTextField("0",15);
        Mem2.setMaximumSize(Mem2.getPreferredSize());

        JLabel Label_Mem3=new JLabel("Mem3:");
        Mem3=new JTextField("0",15);
        Mem3.setMaximumSize(Mem3.getPreferredSize());

        Box BoxMems=Box.createVerticalBox();

        BoxMems.add(Box.createHorizontalStrut(30));
        BoxMems.add(Label_Mem1);
        BoxMems.add(Box.createVerticalStrut(5));
        BoxMems.add(Mem1);



        BoxMems.add(Label_Mem2);
        BoxMems.add(Box.createVerticalStrut(5));
        BoxMems.add(Mem2);


        BoxMems.add(Label_Mem3);
        BoxMems.add(Box.createVerticalStrut(5));
        BoxMems.add(Mem3);
        //Mem1,Mem2,Mem3 end

        //BoxMemsButton start
        Box BoxMemsButtons=Box.createHorizontalBox();
        BoxMemsButtons.add(Box.createHorizontalStrut(30));
        BoxMemsButtons.add(MemoryMCButton);
        BoxMemsButtons.add(Box.createHorizontalStrut(30));
        BoxMemsButtons.add(MemoryVariableButton);
        //BoxMemsButton end

        //result,reset and memory start
        JLabel Label_Result=new JLabel("Result");
        Result=new JTextField("0",35);
        Result.setMaximumSize(Result.getPreferredSize());

        Box BoxResult=Box.createHorizontalBox();
        BoxResult.add(Box.createHorizontalGlue());
        BoxResult.add(Label_Result);
        BoxResult.add(Box.createHorizontalStrut(10));
        BoxResult.add(Result);

        Box Buttonbox=Box.createHorizontalBox();
        Buttonbox.add(Box.createHorizontalGlue());
        Buttonbox.add(BoxResult);
        Buttonbox.add(Box.createHorizontalStrut(30));
        Buttonbox.add(CalcButt);
        Buttonbox.add(Box.createHorizontalStrut(30));
        Buttonbox.add(ResetButt);
        Buttonbox.add(Box.createHorizontalStrut(30));
        Buttonbox.add(MemoryFormulaButton);
        Buttonbox.add(Box.createHorizontalGlue());
        //result,reset and memory end

        //Listenery start
        CalcButt.addActionListener(new CalcButtListener());
        ResetButt.addActionListener(new ResetButtonListener());
        MemoryFormulaButton.addActionListener(new MemoryFuncButtonListener());
        MemoryMCButton.addActionListener(new MemoryMCButtonListener());
        MemoryVariableButton.addActionListener(new MemoryVariableButtonListener());
         //Listenery end

        //final gui start
        Box GUIBox=Box.createVerticalBox();
        GUIBox.add(Box.createVerticalGlue());

        GUIBox.add(boxFormulaType);
        GUIBox.add(boxVariableRadio);
        GUIBox.add(BoxVariables);
        GUIBox.add(BoxResult);
        GUIBox.add(BoxMems);
        GUIBox.add(BoxMemsButtons);
        GUIBox.add(Buttonbox);

        GUIBox.add(Box.createVerticalGlue());

        getContentPane().add(GUIBox,BorderLayout.CENTER);
        //final gui end
    }


    public double Formula1(double x,double y,double z){
        return (Math.sin(y)+y*y+Math.exp(Math.cos(y))*Math.pow(Math.log(z)+Math.sin(PI*x*x),0.25));
        //return x+y+z;
    }

    public double Formula2(double x,double y,double z){
        return ((Math.tan(x*x)*Math.pow(y,0.5))/(z*Math.log(x+y)));
        //return x*y*z;
    }



    private void AddRadioButton(String Name,final int formulaId){
        JRadioButton Radio=new JRadioButton(Name);
        Radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent Event) {
            Frame.this.formulaId=formulaId;
            }
        });
        RadioButtons.add(Radio);
        boxFormulaType.add(Radio);

    }

    private void AddVariableRadioButton(String Name,final int variableId){
        JRadioButton VariableRadio=new JRadioButton(Name);
        VariableRadio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent Event) {
                Frame.this.variableId=variableId;
            }
        });
        VariableRadioButtons.add(VariableRadio);
        boxVariableRadio.add(VariableRadio);

    }


    class CalcButtListener implements ActionListener{
       public void actionPerformed(ActionEvent event){
           try {
                   Double x = Double.parseDouble(Text_X.getText());
    Double y = Double.parseDouble(Text_Y.getText());
    Double z = Double.parseDouble(Text_Z.getText());
    Double result;
    if (formulaId == 1) {
        result = Formula1(x, y, z);
    } else {
        result = Formula2(x, y, z);
    }
    Result.setText(result.toString());

    } catch (NumberFormatException ex) {

    JOptionPane.showMessageDialog(Frame.this,"Wrong number format");
       }}


     }



class ResetButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            Text_X.setText("0");
            Text_Y.setText("0");
            Text_Z.setText("0");
            Result.setText("0");

            Mem1.setText("0");
            Mem2.setText("0");
            Mem3.setText("0");
        }
}

    class MemoryFuncButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            try{
         Double Res=Double.parseDouble(Result.getText());
         SumFunc+=Res;
         Result.setText(SumFunc.toString());
            }
            catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(Frame.this,"Wrong number format");
            }}

        }
      class MemoryMCButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
         if(variableId==1){
          SumCMemory=Double.parseDouble(Result.getText());
           Mem1.setText(SumCMemory.toString());
          }else if(variableId==2){
             SumCMemory=Double.parseDouble(Result.getText());
             Mem2.setText(SumCMemory.toString());
            }else{
             SumCMemory=Double.parseDouble(Result.getText());
             Mem3.setText(SumCMemory.toString());
           }


         }
    }
    class MemoryVariableButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
           Double BuffMemResult;
            if(variableId==1){
                BuffMemResult=Double.parseDouble(Mem1.getText());
                SumVariable=Double.parseDouble(Result.getText());
                SumVariable+=BuffMemResult;
                Mem1.setText(SumVariable.toString());
            }else if(variableId==2){
                BuffMemResult=Double.parseDouble(Mem2.getText());
                SumVariable=Double.parseDouble(Result.getText());
                SumVariable+=BuffMemResult;
                Mem2.setText(SumVariable.toString());
            }else{
                BuffMemResult=Double.parseDouble(Mem3.getText());
                SumVariable=Double.parseDouble(Result.getText());
                SumVariable+=BuffMemResult;
                Mem3.setText(SumVariable.toString());
            }


        }
    }
}




