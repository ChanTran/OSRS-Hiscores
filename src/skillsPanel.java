/*
* Chan Le
* 
*/

import javax.swing.*; // Swing
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class skillsPanel extends JPanel {
	private final static int[] expTable = {83, 174, 276, 388, 512, 650, 801, 969, 1154, 1358, 1584, 1833, 2107, 2411, 2746, 3115, 3523, 3973, 4470, 5018, 5624, 6291, 7028, 7842,
										8740, 9730, 10824, 12031, 13363, 14833, 16456, 18247, 20224, 22406, 24815, 27473, 30408, 33648, 37224, 41171, 45529, 50339,  55649, 61512, 67983,
										75127, 83014, 91721, 101333, 111945, 123660, 136594, 150872, 166636, 184040, 203254, 224466, 247886, 273742, 302288, 333804, 368599, 407015,
										449428, 496254, 547953, 605032, 668051, 737627, 814445, 899257, 992895, 1096278, 1210421, 1336443, 1475581, 1629200, 1798808, 1986068, 2192818,
										2421087, 2673114, 2951373, 3258594, 3597792, 3972294, 4385776, 4842295, 5346332, 5902831, 6517253, 7195629, 7944614, 8771558, 9684577, 10692629,
										11805606, 13034431};
	//Icons
	private JLabel attackIcon;
	private JLabel strengthIcon;
	private JLabel defenceIcon;
	private JLabel rangedIcon;
	private JLabel prayerIcon;
	private JLabel magicIcon;
	private JLabel runecraftIcon;
	private JLabel constructionIcon;
	private JLabel hitpointsIcon;
	private JLabel agilityIcon;
	private JLabel herbloreIcon;
	private JLabel thievingIcon;
	private JLabel craftingIcon;
	private JLabel fletchingIcon;
	private JLabel slayerIcon;
	private JLabel hunterIcon;
	private JLabel miningIcon;
	private JLabel smithingIcon;
	private JLabel fishingIcon;
	private JLabel cookingIcon;
	private JLabel firemakingIcon;
	private JLabel woodcuttingIcon;
	private JLabel farmingIcon;
	//Labels for levels
	private JLabel attack;
	private JLabel strength;
	private JLabel defence;
	private JLabel ranged;
	private JLabel prayer;
	private JLabel magic;
	private JLabel runecraft;
	private JLabel construction;
	private JLabel hitpoints;
	private JLabel agility;
	private JLabel herblore;
	private JLabel thieving;
	private JLabel crafting;
	private JLabel fletching;
	private JLabel slayer;
	private JLabel hunter;
	private JLabel mining;
	private JLabel smithing;
	private JLabel fishing;
	private JLabel cooking;
	private JLabel firemaking;
	private JLabel woodcutting;
	private JLabel farming;
	//JPanels
	private JPanel panelAttack;
	private JPanel panelHitpoints;
	private JPanel panelMining;
	private JPanel panelStrength;
	private JPanel panelAgility;
	private JPanel panelSmithing;
	private JPanel panelDefence;
	private JPanel panelHerblore;
	private JPanel panelFishing;
	private JPanel panelRanged;
	private JPanel panelThieving;
	private JPanel panelCooking;
	private JPanel panelPrayer;
	private JPanel panelCrafting;
	private JPanel panelFiremaking;
	private JPanel panelMagic;
	private JPanel panelFletching;
	private JPanel panelWoodcutting;
	private JPanel panelRunecrafting;
	private JPanel panelSlayer;
	private JPanel panelFarming;
	private JPanel panelConstruction;
	private JPanel panelHunter;
	private NumberFormat numberFormatter = new DecimalFormat("##,###,###");
	
	private String attackXP;
	private String strengthXP;
	private String defenceXP;
	private String rangedXP;
	private String prayerXP;
	private String magicXP;
	private String runecraftXP;
	private String constructionXP;
	private String hitpointsXP;
	private String agilityXP;
	private String herbloreXP;
	private String thievingXP;
	private String craftingXP;
	private String fletchingXP;
	private String slayerXP;
	private String hunterXP;
	private String miningXP;
	private String smithingXP;
	private String fishingXP;
	private String cookingXP;
	private String firemakingXP;
	private String woodcuttingXP;
	private String farmingXP;
	
	//Fields for calculating progress bar
	private double percent;
	private int xpDiff;
	private JPanel panelCenter;
	private JProgressBar levelBar;
	private JPanel levelBarPanel;
	private JLabel levelBarInfo;
	
	public skillsPanel()
	{
		panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(8,3, 5, 2));
		ToolTipManager.sharedInstance().setInitialDelay(0);
		ToolTipManager.sharedInstance().setDismissDelay(Integer.MAX_VALUE);
		setLayout(new BorderLayout());
		buildLevels();
		buildIcons();
		
		//Setting up the panels into each grid layer
		panelAttack = new JPanel();
		panelAttack.add(attackIcon);
		panelAttack.add(attack);
		
		panelHitpoints = new JPanel();
		panelHitpoints.add(hitpointsIcon);
		panelHitpoints.add(hitpoints);
		
		panelMining = new JPanel();
		panelMining.add(miningIcon);
		panelMining.add(mining);
		
		panelStrength = new JPanel();
		panelStrength.add(strengthIcon);
		panelStrength.add(strength);
		
		panelAgility = new JPanel();
		panelAgility.add(agilityIcon);
		panelAgility.add(agility);
		
		panelSmithing = new JPanel();
		panelSmithing.add(smithingIcon);
		panelSmithing.add(smithing);
		
		panelDefence = new JPanel();
		panelDefence.add(defenceIcon);
		panelDefence.add(defence);
		
		panelHerblore = new JPanel();
		panelHerblore.add(herbloreIcon);
		panelHerblore.add(herblore);
		
		panelFishing = new JPanel();
		panelFishing.add(fishingIcon);
		panelFishing.add(fishing);
		
		panelRanged = new JPanel();
		panelRanged.add(rangedIcon);
		panelRanged.add(ranged);
		
		panelThieving = new JPanel();
		panelThieving.add(thievingIcon);
		panelThieving.add(thieving);
		
		panelCooking = new JPanel();
		panelCooking.add(cookingIcon);
		panelCooking.add(cooking);
		
		panelPrayer = new JPanel();
		panelPrayer.add(prayerIcon);
		panelPrayer.add(prayer);
		
		panelCrafting = new JPanel();
		panelCrafting.add(craftingIcon);
		panelCrafting.add(crafting);
		
		panelFiremaking = new JPanel();
		panelFiremaking.add(firemakingIcon);
		panelFiremaking.add(firemaking);
		
		panelMagic = new JPanel();
		panelMagic.add(magicIcon);
		panelMagic.add(magic);
		
		panelFletching = new JPanel();
		panelFletching.add(fletchingIcon);
		panelFletching.add(fletching);
		
		panelWoodcutting = new JPanel();
		panelWoodcutting.add(woodcuttingIcon);
		panelWoodcutting.add(woodcutting);
		
		panelRunecrafting = new JPanel();
		panelRunecrafting.add(runecraftIcon);
		panelRunecrafting.add(runecraft);
		
		panelSlayer = new JPanel();
		panelSlayer.add(slayerIcon);
		panelSlayer.add(slayer);
		
		panelFarming = new JPanel();
		panelFarming.add(farmingIcon);
		panelFarming.add(farming);
		
		panelConstruction = new JPanel();
		panelConstruction.add(constructionIcon);
		panelConstruction.add(construction);
		
		panelHunter = new JPanel();
		panelHunter.add(hunterIcon);
		panelHunter.add(hunter);
		
		Font font = new Font("font", Font.CENTER_BASELINE, 14);
		setBorder(BorderFactory.createTitledBorder(getBorder(), "Skills", TitledBorder.CENTER, TitledBorder.CENTER, font, Color.darkGray));
		
		//Event listener
		panelAttack.addMouseListener(new mouseHover());
		panelHitpoints.addMouseListener(new mouseHover());
		panelMining.addMouseListener(new mouseHover());
		panelStrength.addMouseListener(new mouseHover());
		panelAgility.addMouseListener(new mouseHover());
		panelSmithing.addMouseListener(new mouseHover());
		panelDefence.addMouseListener(new mouseHover());
		panelHerblore.addMouseListener(new mouseHover());
		panelFishing.addMouseListener(new mouseHover());
		panelRanged.addMouseListener(new mouseHover());
		panelThieving.addMouseListener(new mouseHover());
		panelCooking.addMouseListener(new mouseHover());
		panelCrafting.addMouseListener(new mouseHover());
		panelPrayer.addMouseListener(new mouseHover());
		panelFiremaking.addMouseListener(new mouseHover());
		panelMagic.addMouseListener(new mouseHover());
		panelFletching.addMouseListener(new mouseHover());
		panelWoodcutting.addMouseListener(new mouseHover());
		panelRunecrafting.addMouseListener(new mouseHover());
		panelSlayer.addMouseListener(new mouseHover());
		panelFarming.addMouseListener(new mouseHover());
		panelConstruction.addMouseListener(new mouseHover());
		panelHunter.addMouseListener(new mouseHover());
		
		//Add the panels
		panelCenter.add(panelAttack);
		panelCenter.add(panelHitpoints);
		panelCenter.add(panelMining);
		panelCenter.add(panelStrength);
		panelCenter.add(panelAgility);
		panelCenter.add(panelSmithing);
		panelCenter.add(panelDefence);
		panelCenter.add(panelHerblore);
		panelCenter.add(panelFishing);
		panelCenter.add(panelRanged);
		panelCenter.add(panelThieving);
		panelCenter.add(panelCooking);
		panelCenter.add(panelPrayer);
		panelCenter.add(panelCrafting);
		panelCenter.add(panelFiremaking);
		panelCenter.add(panelMagic);
		panelCenter.add(panelFletching);
		panelCenter.add(panelWoodcutting);
		panelCenter.add(panelRunecrafting);
		panelCenter.add(panelSlayer);
		panelCenter.add(panelFarming);
		panelCenter.add(panelConstruction);
		panelCenter.add(panelHunter);
		add(panelCenter, BorderLayout.NORTH);
		
		//Build the panel beneath the skill panel for the level progress bar
		levelBarPanel = new JPanel();
		levelBarPanel.setLayout(new FlowLayout(FlowLayout.CENTER,FlowLayout.CENTER,15));
		levelBar = new JProgressBar(0,100);
		levelBar.setPreferredSize(new Dimension(200,30));
		levelBarPanel.setBorder(BorderFactory.createTitledBorder("Skill Progress"));
		levelBarPanel.add(levelBar);
		levelBarInfo = new JLabel();
		levelBarPanel.add(levelBarInfo);
		panelCenter.add(levelBarPanel);
		levelBar.setVisible(false);
		levelBarInfo.setVisible(false);
		add(levelBarPanel, BorderLayout.CENTER);
		levelBarPanel.setPreferredSize(new Dimension(150, 110));
	}
	
	private void updateBar(double percent, int XP)
	{
		System.out.println(percent);
		levelBar.setValue((int)percent);
		levelBar.setString(String.valueOf((int)percent) + "%");
		levelBar.setStringPainted(true);
		levelBarInfo.setText("Exp until next level: " + numberFormatter.format(XP));
		levelBarInfo.setVisible(true);
		levelBar.setVisible(true);
	}
	private void disableInfo()
	{
		levelBar.setVisible(false);
		levelBarInfo.setVisible(false);
	}
	
	private void buildLevels()
	{
		attack = new JLabel("--");
		strength = new JLabel("--");
		defence = new JLabel("--");
		ranged = new JLabel("--");
		prayer = new JLabel("--");
		magic = new JLabel("--");
		runecraft = new JLabel("--");
		construction = new JLabel("--");
		hitpoints = new JLabel("--");
		agility = new JLabel("--");
		agility = new JLabel("--");
		herblore = new JLabel("--");
		thieving = new JLabel("--");
		crafting = new JLabel("--");
		fletching = new JLabel("--");
		slayer = new JLabel("--");
		hunter = new JLabel("--");
		mining = new JLabel("--");
		smithing = new JLabel("--");
		fishing = new JLabel("--");
		cooking = new JLabel("--");
		firemaking = new JLabel("--");
		woodcutting = new JLabel("--");
		farming = new JLabel("--");
	}
	
	private void buildIcons()
	{
		ImageIcon attackI = new ImageIcon(getClass().getResource("/icons/Attack_icon.png"));
		ImageIcon strengthI = new ImageIcon(getClass().getResource("/icons/Strength-icon.png"));
		ImageIcon defenceI = new ImageIcon(getClass().getResource("/icons/Defence-icon.png"));
		ImageIcon rangedI = new ImageIcon(getClass().getResource("/icons/Ranged-icon.png"));
		ImageIcon prayerI = new ImageIcon(getClass().getResource("/icons/Prayer-icon.png"));
		ImageIcon magicI = new ImageIcon(getClass().getResource("/icons/Magic-icon.png"));
		ImageIcon runecraftI = new ImageIcon(getClass().getResource("/icons/Runecrafting-icon.png"));
		ImageIcon constructionI = new ImageIcon(getClass().getResource("/icons/Construction_icon.png"));
		ImageIcon hitpointsI = new ImageIcon(getClass().getResource("/icons/Hitpoints_icon.png"));
		ImageIcon agilityI = new ImageIcon(getClass().getResource("/icons/Agility-icon.png"));
		ImageIcon herbloreI = new ImageIcon(getClass().getResource("/icons/Herblore-icon.png"));
		ImageIcon thievingI = new ImageIcon(getClass().getResource("/icons/Thieving-icon.png"));
		ImageIcon craftingI = new ImageIcon(getClass().getResource("/icons/Crafting-icon.png"));
		ImageIcon fletchingI = new ImageIcon(getClass().getResource("/icons/Fletching-icon.png"));
		ImageIcon slayerI = new ImageIcon(getClass().getResource("/icons/Slayer-icon.png"));
		ImageIcon hunterI = new ImageIcon(getClass().getResource("/icons/Hunter-icon.png"));
		ImageIcon miningI = new ImageIcon(getClass().getResource("/icons/Mining-icon.png"));
		ImageIcon smithingI = new ImageIcon(getClass().getResource("/icons/Smithing-icon.png"));
		ImageIcon fishingI = new ImageIcon(getClass().getResource("/icons/Fishing-icon.png"));
		ImageIcon cookingI = new ImageIcon(getClass().getResource("/icons/Cooking-icon.png"));
		ImageIcon firemakingI = new ImageIcon(getClass().getResource("/icons/Firemaking-icon.png"));
		ImageIcon woodcuttingI = new ImageIcon(getClass().getResource("/icons/Woodcutting-icon.png"));
		ImageIcon farmingI = new ImageIcon(getClass().getResource("/icons/Farming-icon.png"));
		
		//Add the icons as JLabels
		attackIcon = new JLabel(attackI);
		strengthIcon = new JLabel(strengthI);
		defenceIcon = new JLabel(defenceI);
		rangedIcon = new JLabel(rangedI);
		prayerIcon = new JLabel(prayerI);
		magicIcon = new JLabel(magicI);
		runecraftIcon = new JLabel(runecraftI);
		constructionIcon = new JLabel(constructionI);
		hitpointsIcon = new JLabel(hitpointsI);
		agilityIcon = new JLabel(agilityI);
		herbloreIcon = new JLabel(herbloreI);
		thievingIcon = new JLabel(thievingI);
		craftingIcon = new JLabel(craftingI);
		fletchingIcon = new JLabel(fletchingI);
		slayerIcon = new JLabel(slayerI);
		hunterIcon = new JLabel(hunterI);
		miningIcon = new JLabel(miningI);
		smithingIcon = new JLabel(smithingI);
		fishingIcon = new JLabel(fishingI);
		cookingIcon = new JLabel(cookingI);
		firemakingIcon = new JLabel(firemakingI);
		woodcuttingIcon = new JLabel(woodcuttingI);
		farmingIcon = new JLabel(farmingI);
	}
	
	private class mouseHover implements MouseListener
	{
		public void mouseClicked(MouseEvent e)
		{		
		}
		public void mouseReleased(MouseEvent e)
		{
		}
		public void mouseExited(MouseEvent e)
		{
			disableInfo();
		}
		public void mouseEntered(MouseEvent e)
		{
			if(attackXP == null || attackXP.equals("--"))
			{
			}
			else
			{
				if(e.getSource() == panelAttack)
				{
					calculateXpDiff(attackXP);
				}
				if(e.getSource() == panelMining)
				{
					calculateXpDiff(miningXP);
				}
				if(e.getSource() == panelStrength)
				{
					calculateXpDiff(strengthXP);
				}
				if(e.getSource() == panelAgility)
				{
					calculateXpDiff(agilityXP);
				}
				if(e.getSource() == panelSmithing)
				{
					calculateXpDiff(smithingXP);
				}
				if(e.getSource() == panelDefence)
				{
					calculateXpDiff(defenceXP);
				}
				if(e.getSource() == panelHerblore)
				{
					calculateXpDiff(herbloreXP);
				}
				if(e.getSource() == panelFishing)
				{
					calculateXpDiff(fishingXP);
				}
				if(e.getSource() == panelRanged)
				{
					calculateXpDiff(rangedXP);
				}
				if(e.getSource() == panelThieving)
				{
					calculateXpDiff(thievingXP);
				}
				if(e.getSource() == panelCooking)
				{
					calculateXpDiff(cookingXP);
				}
				if(e.getSource() == panelPrayer)
				{
					calculateXpDiff(prayerXP);
				}
				if(e.getSource() == panelCrafting)
				{
					calculateXpDiff(craftingXP);
				}
				if(e.getSource() == panelFiremaking)
				{
					calculateXpDiff(firemakingXP);
				}
				if(e.getSource() == panelMagic)
				{
					calculateXpDiff(magicXP);
				}
				if(e.getSource() == panelFletching)
				{
					calculateXpDiff(fletchingXP);
				}
				if(e.getSource() == panelWoodcutting)
				{
					calculateXpDiff(woodcuttingXP);
				}
				if(e.getSource() == panelRunecrafting)
				{
					calculateXpDiff(runecraftXP);
				}
				if(e.getSource() == panelSlayer)
				{
					calculateXpDiff(slayerXP);
				}
				if(e.getSource() == panelFarming)
				{
					calculateXpDiff(farmingXP);
				}
				if(e.getSource() == panelConstruction)
				{
					calculateXpDiff(constructionXP);
				}
				if(e.getSource() == panelHunter)
				{
					calculateXpDiff(hunterXP);
				}
				if(e.getSource() == panelHitpoints)
				{
					calculateXpDiff(hitpointsXP);
				}
			}
		}
		public void mousePressed(MouseEvent e)
		{
		}
	}
	
	private void calculateXpDiff(String XP)
	{
		percent = 0.0;
		xpDiff = 0;
		for(int i = 0; i < expTable.length; i++)
		{
			int userXP = Integer.parseInt(XP);
			if(i == 0 && userXP < expTable[i])
			{
				percent = (double)userXP/expTable[i] * 100.0;
				xpDiff = expTable[i] - userXP;
				break;
			}
			else if(userXP<expTable[i])
			{
				double subt = (userXP - expTable[i-1]);
				double subtArr = expTable[i] - expTable[i-1];
				percent = (subt/subtArr) * 100.0;
				xpDiff = expTable[i] - userXP;
				break;
			}
			else if(i == expTable[expTable.length-1] && userXP>expTable[i])
			{
				percent = 0.0;
				xpDiff = 0;
				break;
			}
			else if(userXP>expTable[i])
			{
				continue;
			}
		}
		updateBar(percent, xpDiff);
	}
	
	private void setSkill(JLabel skillLabel, JPanel panelUpdate, String skill, String level, String XP, String rank)
	{
		skillLabel.setText(level);
		if(level.equals("--"))
		{
			panelUpdate.setToolTipText("<html>"
                    + skill.toUpperCase()
                    +"<br>"
                    + "Total XP: Not Available" +"<br>" + "Rank: Not Available"
               + "</html>");
			panelUpdate.validate();
			panelUpdate.repaint();
		}
		else
		{
			String formattedNumberXP = numberFormatter.format(Integer.parseInt(XP));
			String formattedNumberRank = numberFormatter.format(Integer.parseInt(rank));
			panelUpdate.setToolTipText("<html>"
                              + skill.toUpperCase()
                              +"<br>"
                              + "Total XP: " + formattedNumberXP +"<br>" + "Rank: " + formattedNumberRank
                         + "</html>");
			panelUpdate.validate();
			panelUpdate.repaint();
		}
	}
	
	public void setAttack(String level, String XP, String rank)
	{
		attackXP = XP;
		setSkill(attack, panelAttack, "Attack", level, XP, rank);
	}
	public void setStrength(String level, String XP, String rank)
	{
		strengthXP = XP;
		setSkill(strength, panelStrength, "Strength", level, XP, rank);
	}
	public void setDefence(String level, String XP, String rank)
	{
		defenceXP = XP;
		setSkill(defence, panelDefence, "Defence", level, XP, rank);
	}
	public void setRanged(String level, String XP, String rank)
	{
		rangedXP = XP;
		setSkill(ranged, panelRanged, "Ranged", level, XP, rank);
	}
	public void setPrayer(String level, String XP, String rank)
	{
		prayerXP = XP;
		setSkill(prayer, panelPrayer, "Prayer", level, XP, rank);
	}
	public void setMagic(String level, String XP, String rank)
	{
		magicXP = XP;
		setSkill(magic, panelMagic, "Magic", level, XP, rank);
	}
	public void setRunecraft(String level, String XP, String rank)
	{
		runecraftXP = XP;
		setSkill(runecraft, panelRunecrafting, "Runecraft", level, XP, rank);
	}
	public void setConstruction(String level, String XP, String rank)
	{
		constructionXP = XP;
		setSkill(construction, panelConstruction, "Construction", level, XP, rank);
	}
	public void setHitpoints(String level, String XP, String rank)
	{
		hitpointsXP = XP;
		setSkill(hitpoints, panelHitpoints, "Hitpoints", level, XP, rank);
	}
	public void setAgility(String level, String XP, String rank)
	{
		agilityXP = XP;
		setSkill(agility, panelAgility, "Agility", level, XP, rank);
	}
	public void setHerblore(String level, String XP, String rank)
	{
		herbloreXP = XP;
		setSkill(herblore, panelHerblore, "Herblore", level, XP, rank);
	}
	public void setThieving(String level, String XP, String rank)
	{
		thievingXP = XP;
		setSkill(thieving, panelThieving, "Thieving", level, XP, rank);
	}
	public void setCrafting(String level, String XP, String rank)
	{
		craftingXP = XP;
		setSkill(crafting, panelCrafting, "Crafting", level, XP, rank);
	}
	public void setFletching(String level, String XP, String rank)
	{
		fletchingXP = XP;
		setSkill(fletching, panelFletching, "Fletching", level, XP, rank);
	}
	public void setSlayer(String level, String XP, String rank)
	{
		slayerXP = XP;
		setSkill(slayer, panelSlayer, "Slayer", level, XP, rank);
	}
	public void setHunter(String level, String XP, String rank)
	{
		hunterXP = XP;
		setSkill(hunter, panelHunter, "Hunter", level, XP, rank);
	}
	public void setMining(String level, String XP, String rank)
	{
		miningXP = XP;
		setSkill(mining, panelMining, "Mining", level, XP, rank);
	}
	public void setSmithing(String level, String XP, String rank)
	{
		smithingXP = XP;
		setSkill(smithing, panelSmithing, "Smithing", level, XP, rank);
	}
	public void setFishing(String level, String XP, String rank)
	{
		fishingXP = XP;
		setSkill(fishing, panelFishing, "Fishing", level, XP, rank);
	}
	public void setCooking(String level, String XP, String rank)
	{
		cookingXP = XP;
		setSkill(cooking, panelCooking, "Cooking", level, XP, rank);
	}
	public void setFiremaking(String level, String XP, String rank)
	{
		firemakingXP = XP;
		setSkill(firemaking, panelFiremaking, "Firemaking", level, XP, rank);
	}
	public void setWoodcutting(String level, String XP, String rank)
	{
		woodcuttingXP = XP;
		setSkill(woodcutting, panelWoodcutting, "Woodcutting", level, XP, rank);
	}
	public void setFarming(String level, String XP, String rank)
	{
		farmingXP = XP;
		setSkill(farming, panelFarming, "Farming", level, XP, rank);
	}
	
}
