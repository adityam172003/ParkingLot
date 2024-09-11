package monitor;

import java.util.*;

public class BoardObserver {

		private List<List<Boolean>>board;
		
		public BoardObserver(int levels ,int spots) {
			
			System.out.println("Levels = "+levels + "Spots = "+spots);
			board = new ArrayList();
			for(int i =0;i<levels;i++) {
				board.add(new ArrayList());
				for(int j=0;j<spots;j++) {
					board.get(i).add(true);
				}
			}
			
			print();
			System.out.println("----------------------------------------------------------");
		}
		
		
	
		public void update(int level,int spot ,boolean status)
		{
			board.get(level).set(spot, status);
			print();
			System.out.println("----------------------------------------------------------");
		
		}
		
		
		private void print() {
			
			
			for(int i=0;i<board.size();i++) {
				
				for(int j=0;j<board.get(i).size();j++) {
					
					System.out.print(board.get(i).get(j)+" ");
				}
				
				System.out.println();
			}
			
			
		}
}
