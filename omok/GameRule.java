package com.omok;

public class GameRule {
	private final int PLYAER_CNT = 2; // �÷��̾� �� 
	private int playerOrder = 1; // �÷��� ����
	private int maxSize = 20; // ������ ����
	private int map[][] = new int[maxSize][maxSize]; // �迭 ����
	
	// map �迭�� ������ 0���� �ʱ�ȭ
	public void init() {
		for(int i=0;i<maxSize;i++) {
			for(int j=0;j<maxSize;j++) {
				map[i][j] = 0;
			}
		}
	}
	
	// �÷��� ����
	public void nextPlayer() {
		switch(playerOrder) {
		case 1 : playerOrder = 2; break;
		case 2 : playerOrder = 1; break;
		default : break;
		}
	}
	
	// ���� �¸� ����
	public boolean endGame(Stone s) {
		int nowColor = s.getColor();
		int dir[][] = {{0,1},{0,-1},{-1,0},{1,0},{-1,1},{1,-1},{1,1},{-1,-1}}; //�ΰ� �� �� �������� �ݺ�
		
		for(int i =0;i<8;i=i+2) {
			int same_cnt = 1;
			int locX = s.getX();
			int locY = s.getY();
			
			// ���� �� �� ���� ���� (���ʹ���)
			for(int j=0;j<5;j++) {
				locX += dir[i][0];
				locY += dir[i][1];
				if(locX < 0 || locX >= maxSize || locY <0 || locY >= maxSize)
					break;
				if(nowColor != map[locX][locY])
					break;
				same_cnt ++;
			}
			
			locX = s.getX();
			locY = s.getY();
			
			// ���� �� �� ���� ���� (�ݴ����)
			for(int j=0;j<5;j++) {
				locX += dir[i+1][0];
				locY += dir[i+1][1];
				
				if(locX < 0 || locX >= maxSize || locY <0 || locY >= maxSize)
					break;
				if(nowColor != map[locX][locY])
					break;
				same_cnt ++;
			}
			
			if(same_cnt >=5)
				return true;
		}
		return false;
	}
	
	public void inputStone(Stone s) {
		map[s.getX()][s.getY()] = s.getColor();
	}
	
	public boolean checkInput(int x, int y) {
		if(map[x][y] !=0 || x<0 || x>=maxSize || y<0 || y >= maxSize)
			return false;
		return true;
	}
	
	public int[][] getMap() {
		return map;
	}
	
	public int getPlayerOrder() {
		return playerOrder;
	}
	
	
}
