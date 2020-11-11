package calculatrice;

import java.awt.*;  
import java.awt.event.*;  
class Graphique extends Frame 
{  
    TextField tf;
    String st = ""; // cette chaine va être remplise par l'utilisateur  
    Graphique()
    {   
        //Création des composants
        tf=new TextField();   
        tf.setBounds(60,50,170,20);  
        int x=10,y=100;
        Button b1 = CreateButt("1",x,y);add(b1);
        Button b2 = CreateButt("2",x+50,y);add(b2);
        Button b3 = CreateButt("3",x+100,y);add(b3);
        Button bp = CreateButt("+",x+150,y);add(bp);

        Button b4 = CreateButt("4",x,y+50);add(b4);
        Button b5 = CreateButt("5",x+50,y+50);add(b5);
        Button b6 = CreateButt("6",x+100,y+50);add(b6);
        Button bm = CreateButt("-",x+150,y+50);add(bm);


        Button b7 = CreateButt("7",x,y+100);add(b7);
        Button b8 = CreateButt("8",x+50,y+100);add(b8);
        Button b9 = CreateButt("9",x+100,y+100);add(b9);
        Button bf = CreateButt("x",x+150,y+100);add(bf);

        Button bpo = CreateButt("(",x+200,y+50);add(bpo);
        Button b0 = CreateButt("0",x+50,y+150);add(b0);
        Button bpt = CreateButt(".",x+100,y+150);add(bpt);
        Button bpf = CreateButt(")",x+200,y+100);add(bpf);    
        Button bd = CreateButt("/",x+150,y+150);add(bd);
        // '=' Button 
        Button be = new Button("=");
        be.setBounds(x+200,y+150,70,40);
        be.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
                Expression exp = new Expression(st);
                if(!exp.isGood())
                    tf.setText("Expression is not valid");
                else
                {
                    try
                    {
                        double result=exp.Evaluate();
                        st=""+result;
                        tf.setText(st);
                    }
                    catch (Exception ex) 
                    {
                       tf.setText("ZERO DIVISION !! ");
                    } 
                }
                
            }  
        });
        add(be);
        
        //clear button
        Button bc = new Button("CLEAR");
        bc.setBounds(x+200,y,70,40);
        bc.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){  
                    st="";    
                    tf.setText(st);  
                }  
            });  
        add(bc);
        add(tf);
        setSize(300,300);  
        setLayout(null);  
        setVisible(true);  
    }
    private Button CreateButt(String name,int x,int y)
    {
        Button b = new Button(name);
        b.setBounds(x,y,40,40);
        b.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
                st+=name;    
                tf.setText(st);  
            }  
        });  
        return b;
    }
} 