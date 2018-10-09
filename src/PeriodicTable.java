/**
  * This is my code!  It's goal is to parse a string into symbols from the
  * periodic table of the elements because Chemistry is phun!
  * CS 312 - Lab 5b 
  * @author 
  * @version 0.98 DATE
  */

import java.util.ArrayList;

public class PeriodicTable
{

    public static void main(String[] args)
    {
        PeriodicTable pt = new PeriodicTable();
        pt.parse(args);
    }

    // first element is a space to match the spaces between words
    public static final String[] symbols =
    { " ", "H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K",
            "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb",
            "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs",
            "Ba", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra",
            "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og", "La", "Ce", "Pr",
            "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Ac", "Th", "Pa", "U", "Np", "Pu",
            "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr" };

    /*
     * purpose: joins an array of strings into a single space-separated string
     * input: the array of strings, strings output: the joined string
     */
    private static String join(String[] strings)
    {
        String x = "";
        for (String s : strings)
            x += s + " ";
        return x;
    }

    /*
     * purpose: find the element symbols that prefix a string input: the string, of
     * output: a list of the prefix symbols
     */
    public static ArrayList<String> prefixMatches(String of)
    {
        ArrayList<String> ans = new ArrayList<String>();
        for(String x:symbols)
        {
            if(x.toUpperCase().equals(of.toUpperCase().substring(0, x.length())))
            {
							System.out.println("Element Option: " +  x );
							ans.add(x);
        		}
				}
        return ans;
    }

    /*
     * purpose: entry point for parser input: an array of string to parse, strings
     * output: an array of element symbols or an empty array if unparsable
     */
    public void parse(String[] strings)
    {
        String goal = strings.length == 0 ? "Brew Practitioners" : join(strings);
        ArrayList<String> solution = new ArrayList<>();
        Boolean ok = this.search(goal, solution);
        if (ok)
            System.out.println("got it! " + solution);
        else
            System.out.println("rats parse failed :( for goal " + goal);
    }

    /*
     * purpose: search for a list of element symbols that make up a string input:
     * the string to break down into symbols, goal output: the symbols, solution,
     * and true iff goal is parseable
     */
  public Boolean search(String goal, ArrayList<String> solution)
  {
		System.out.println( goal );
    if (goal.length() == 0)
      return false;
    else if(prefixMatches(goal).size() == 0)
				return false;
		else
		{	
      for(String x:prefixMatches(goal))
      {
        	solution.add(x);
					System.out.println( "adding solution " + x + "\nCurrent solution: " + solution.toString());
					if(goal.length() - x.length() <= 0)
						return true;
				  else if(search(goal.substring(x.length(), goal.length()), solution))
						return true;
					else
						solution.remove(solution.size()-1);
      }
      return false;
    }
    
  }
}

/*
 * some tests java PeriodicTable Brew java PeriodicTable Brew Practitioners java
 * PeriodicTable java PeriodicTable Sponge Bob java PeriodicTable black java
 * PeriodicTable blue java PeriodicTable brown java PeriodicTable copper beer
 * java PeriodicTable ebony beer java PeriodicTable green java PeriodicTable
 * orange java PeriodicTable pink beer java PeriodicTable red java PeriodicTable
 * smoke beer java PeriodicTable white hole java PeriodicTable yellow
 */
