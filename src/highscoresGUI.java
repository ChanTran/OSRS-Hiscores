import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;


public class highscoresGUI extends JFrame {
	private final static int NUMBERS_DATA = 24;
	private skillsPanel skills;
	private JPanel namePanel;
	private JPanel totalLevelPanel;
	private JTextField name;
	private JTextField totalLevel;
	private JLabel totalLabel;
	private JTextField totalLevelXP;
	private JTextField totalLevelRank;
	private JLabel totalLevelXPLabel;
	private JLabel totalLevelRankLabel;
	private String[] skillsSplit;
	private String[] skillsSplitXP;
	private String[] skillsSplitRank;
	private NumberFormat numberFormatter = new DecimalFormat("##,###,###");
	
	public highscoresGUI()
	{
		setTitle("OSRS Highscores Searcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		skills = new skillsPanel();
		buildNamePanel();
		buildTotalLevelPanel();
		
		add(namePanel, BorderLayout.NORTH);
		add(skills, BorderLayout.CENTER);
		add(totalLevelPanel, BorderLayout.SOUTH);
		
		setResizable(false);
		pack();
		setVisible(true);
		
		
		JOptionPane.showMessageDialog(null, "Welcome to OSRS Highscores Searcher\n"
										+ "\nVer 1.2: \nAdded skill progress bar, style changes to title and layout."
										+ "\nVer 1.1:\nMinor bug fixes and changes to GUI layout."
										+ "\nVer 1.0:\nProject created and never to be updated again.");
		
	}
	/*
		Build all the panels and add mouse listeners to them
	 */
	private void buildNamePanel()
	{
		namePanel = new JPanel();
		name = new JTextField("Enter a username", 10);
		name.addActionListener(new SearchListener());
		name.addMouseListener(new mouseClick());
		name.addFocusListener(new MyFocusListener());
		
		Font font = new Font("font", Font.CENTER_BASELINE, 14);
		namePanel.setBorder(BorderFactory.createTitledBorder(namePanel.getBorder(), "Username", TitledBorder.CENTER, TitledBorder.CENTER, font, Color.darkGray));
		
		Border outer = name.getBorder();
		Border search = new MatteBorder(0, 16, 0, 0, new ImageIcon(getClass().getResource("/icons/1.png")));
		name.setBorder(new CompoundBorder(outer, search));
		
		
		namePanel.add(name);
	}
	private void buildTotalLevelPanel()
	{
		totalLevelPanel = new JPanel();
		totalLevelPanel.setLayout(new GridLayout(3,2, 5 , 5));
		totalLevelPanel.setBorder(BorderFactory.createTitledBorder("Misc."));
		totalLabel = new JLabel("Total Level: ");
		totalLevel = new JTextField("--", 10);
		totalLevel.setEditable(false);
		totalLevelPanel.add(totalLabel);
		totalLevelPanel.add(totalLevel);
		//Total level XP and Rank
		totalLevelXPLabel = new JLabel("Total Level XP: ");
		totalLevelXP = new JTextField("--", 10);
		
		totalLevelRankLabel = new JLabel("Total Level Rank: ");
		totalLevelRank = new JTextField("--", 10);
		
		totalLevelRank.setEditable(false);
		totalLevelXP.setEditable(false);
		
		totalLevelPanel.add(totalLevelXPLabel);
		totalLevelPanel.add(totalLevelXP);
		totalLevelPanel.add(totalLevelRankLabel);
		totalLevelPanel.add(totalLevelRank);
	}
	
	private class mouseClick implements MouseListener
	{
		public void mouseClicked(MouseEvent e)
		{
			if(name.getText().contains("Enter a username"))
			{
				name.setText("");
			}
		}
		public void mouseReleased(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
		}
		public void mouseEntered(MouseEvent e)
		{
		}
		public void mousePressed(MouseEvent e)
		{
		}
	}
	
	private class MyFocusListener extends FocusAdapter {
		   @Override
		   public void focusGained(FocusEvent fEvt) {
		      JTextComponent component = (JTextComponent) fEvt.getSource();
		      component.selectAll();
		   }
		}
	
	private class SearchListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String theName = name.getText();
			String[] arr = URLinformation.getSkillLevels(theName);
			//If arr length == 0, this means that the username is invalid or the webpage was not found.
			if(arr.length == 0)
			{
				totalLevelXP.setText("--");
				totalLevelRank.setText("--");
				totalLevel.setText("--");
				skills.setAttack("--", "--", "--");
				skills.setDefence("--", "--", "--");
				skills.setStrength("--", "--", "--");
				skills.setHitpoints("--", "--", "--");
				skills.setRanged("--", "--", "--");
				skills.setPrayer("--", "--", "--");
				skills.setMagic("--", "--", "--");
				skills.setCooking("--", "--", "--");
				skills.setWoodcutting("--", "--", "--");
				skills.setFletching("--", "--", "--");
				skills.setFishing("--", "--", "--");
				skills.setFiremaking("--", "--", "--");
				skills.setCrafting("--", "--", "--");
				skills.setSmithing("--", "--", "--");
				skills.setMining("--", "--", "--");
				skills.setHerblore("--", "--", "--");
				skills.setAgility("--", "--", "--");
				skills.setThieving("--", "--", "--");
				skills.setSlayer("--", "--", "--");
				skills.setFarming("--", "--", "--");
				skills.setRunecraft("--", "--", "--");
				skills.setHunter("--", "--", "--");
				skills.setConstruction("--", "--", "--");
				JOptionPane.showMessageDialog(null, "Username not found. Please input a valid username.");
			}
			else
			{
				skillsSplit = new String[NUMBERS_DATA];
				skillsSplitXP = new String[NUMBERS_DATA];
				skillsSplitRank = new String[NUMBERS_DATA];
				for(int i = 0; i < NUMBERS_DATA; i++)
				{
					String[] commaSplit = arr[i].split(",");
					if(commaSplit[0].equals("-1"))
						skillsSplitRank[i] = "0"; // The index at 0 displays the rank of the skill
					else
						skillsSplitRank[i] = commaSplit[0];
					skillsSplit[i] = commaSplit[1]; // The index at 1 displays the level of the skill
					if(commaSplit[2].equals("-1")) // The index at 2 displays the xp gained in the skill
						skillsSplitXP[i] = "0";
					else
						skillsSplitXP[i] = commaSplit[2];
				}
				totalLevel.setText(skillsSplit[0]);
				totalLevelXP.setText(numberFormatter.format(Long.parseLong(skillsSplitXP[0])));
				totalLevelRank.setText(numberFormatter.format(Long.parseLong(skillsSplitRank[0])));
				
				//Updating the skills panel based off of info read off of runescape website
				skills.setAttack(skillsSplit[1], skillsSplitXP[1], skillsSplitRank[1]);
				skills.setDefence(skillsSplit[2], skillsSplitXP[2], skillsSplitRank[2]);
				skills.setStrength(skillsSplit[3], skillsSplitXP[3], skillsSplitRank[3]);
				skills.setHitpoints(skillsSplit[4], skillsSplitXP[4], skillsSplitRank[4]);
				skills.setRanged(skillsSplit[5], skillsSplitXP[5], skillsSplitRank[5]);
				skills.setPrayer(skillsSplit[6], skillsSplitXP[6], skillsSplitRank[6]);
				skills.setMagic(skillsSplit[7], skillsSplitXP[7], skillsSplitRank[7]);
				skills.setCooking(skillsSplit[8], skillsSplitXP[8], skillsSplitRank[8]);
				skills.setWoodcutting(skillsSplit[9], skillsSplitXP[9], skillsSplitRank[9]);
				skills.setFletching(skillsSplit[10], skillsSplitXP[10], skillsSplitRank[10]);
				skills.setFishing(skillsSplit[11], skillsSplitXP[11], skillsSplitRank[11]);
				skills.setFiremaking(skillsSplit[12], skillsSplitXP[12], skillsSplitRank[12]);
				skills.setCrafting(skillsSplit[13], skillsSplitXP[13], skillsSplitRank[13]);
				skills.setSmithing(skillsSplit[14], skillsSplitXP[14], skillsSplitRank[14]);
				skills.setMining(skillsSplit[15], skillsSplitXP[15], skillsSplitRank[15]);
				skills.setHerblore(skillsSplit[16], skillsSplitXP[16], skillsSplitRank[16]);
				skills.setAgility(skillsSplit[17], skillsSplitXP[17], skillsSplitRank[17]);
				skills.setThieving(skillsSplit[18], skillsSplitXP[18], skillsSplitRank[18]);
				skills.setSlayer(skillsSplit[19], skillsSplitXP[19], skillsSplitRank[19]);
				skills.setFarming(skillsSplit[20], skillsSplitXP[20], skillsSplitRank[20]);
				skills.setRunecraft(skillsSplit[21], skillsSplitXP[21], skillsSplitRank[21]);
				skills.setHunter(skillsSplit[22], skillsSplitXP[22], skillsSplitRank[22]);
				skills.setConstruction(skillsSplit[23], skillsSplitXP[23], skillsSplitRank[23]);
			}
		}
	}
	
public static void main(String[] args)
	{
		new highscoresGUI();
	}
}
