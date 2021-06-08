import javax.swing.JOptionPane;

class PermutationGenerator
  { private String word;
    private int current;
    private PermutationGenerator tailGenerator;
    public PermutationGenerator(String aWord)
      { word = aWord;
        current = 0;
        if (word.length() > 1)
          { tailGenerator = new PermutationGenerator(word.substring(1));
          }
       }
    public String nextPermutation()
      { if (word.length() == 1)
          { current++;
             return word;
          }
        String r = word.charAt(current) + tailGenerator.nextPermutation();
        if (!tailGenerator.hasMorePermutations())
          { current++;
             if (current < word.length())
                { String tailString = word.substring(0, current) + word.substring(current+1);
                   tailGenerator = new PermutationGenerator(tailString);
                }
          }
        return r;
      }
    public boolean hasMorePermutations()
      { return current < word.length();
      }
  }
public class Main
  { public static void main(String[] args)
       { String input = JOptionPane.showInputDialog("Enter a word");
          PermutationGenerator perms = new PermutationGenerator(input);
          while (perms.hasMorePermutations())
              { System.out.println(perms.nextPermutation());
              }
        }
   }