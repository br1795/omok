package com.omok;

public class GameRule {
	private final int PLYAER_CNT = 2; // 플레이어 수 
	private int playerOrder = 1; // 플레이 순서
	private int maxSize = 20; // 오목판 길이
	private int map[][] = new int[maxSize][maxSize]; // 배열 선언
	
	// map 배열의 모든원소 0으로 초기화
	public void init() {
		for(int i=0;i<maxSize;i++) {
			for(int j=0;j<maxSize;j++) {
				map[i][j] = 0;
			}
		}
	}
	
	// 플레이 순서
	public void nextPlayer() {
		switch(playerOrder) {
		case 1 : playerOrder = 2; break;
		case 2 : playerOrder = 1; break;
		default : break;
		}
	}
	
	// 게임 승리 조건
	public boolean endGame(Stone s) {
		int nowColor = s.getColor();
		int dir[][] = {{0,1},{0,-1},{-1,0},{1,0},{-1,1},{1,-1},{1,1},{-1,-1}}; //두개 씩 한 묶음으로 반복
		
		for(int i =0;i<8;i=i+2) {
			int same_cnt = 1;
			int locX = s.getX();
			int locY = s.getY();
			
			// 같은 색 돌 갯수 세기 (한쪽방향)
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
			
			// 같은 색 돌 갯수 세기 (반대방향)
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
