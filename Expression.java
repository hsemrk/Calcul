package calculatrice;
import java.util.Stack;
class Expression 
{
    private String Expr;
    Expression(String s) // constructeur 
    {
        Expr=s;
    }
    
    private String toPostfix() //transformer Expr de la representation infixé vers postfixé
    {
        Stack<Character> pile = new Stack<>(); 
        String s1="";
        int i=0;
        while(i<Expr.length())
        {
            if(Expr.charAt(i)!='(')
            {
                if(Expr.charAt(i)==')')s1 +=pile.pop();
                if(Character.isDigit(Expr.charAt(i)))
                {
                    while(i<Expr.length() && (Character.isDigit(Expr.charAt(i)) || Expr.charAt(i)=='.'))
                    {
                        s1+=Expr.charAt(i);i++;
                    }
                    s1+=" ";i--;
                }
                if(i<Expr.length() && (Expr.charAt(i)=='+' || Expr.charAt(i)=='x' || Expr.charAt(i)=='-' || Expr.charAt(i)=='/'))
                {
                    if(!pile.empty())s1+=pile.pop();
                    pile.push(Expr.charAt(i));
                }
            }
            i++;
        }
        if(!pile.empty())s1+=pile.pop();
        return s1;
    }
    
    boolean isGood() // Tester si l'expression est bien paranthèsée
    {
        Stack<Character> p = new Stack<>();
        for(int i=0; i<Expr.length(); i++)
        {
            if(Expr.charAt(i)=='(')p.push('(');
            if(Expr.charAt(i)==')')
            {
                if(p.empty())return false;
                p.pop();
            }
        }
        if(p.empty())return true;
        return false;
    }
    
    double Evaluate() // calculer la resultat
    {
        String s = this.toPostfix();
        double x;int j=0;
        String sx="";
        while(Character.isDigit(s.charAt(j)) || s.charAt(j)=='.')
        {
            sx+=s.charAt(j);
            j++;
        }
        x=Double.valueOf(sx);sx="";
        for(int i = j ; i < s.length() ; i++)
        {
            if(s.charAt(i)==' ')i++;
            double x2;
            while(Character.isDigit(s.charAt(i)) || s.charAt(i)=='.')
            {
                sx+=s.charAt(i);
                i++;
            }
            x2=Double.valueOf(sx);sx="";
            if(s.charAt(i)==' ')i++;
            char op=s.charAt(i);
            switch (op) {
                case '+':
                    x+=x2;
                    break;
                case '-':
                    x-=x2;
                    break;
                case 'x':
                    x*=x2;
                    break;
                case '/':
                    x/=x2;
                    break;
                default:
                    break;
            }
        }
        return x;
    }
}