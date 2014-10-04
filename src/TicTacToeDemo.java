import aima.core.search.adversarial.AdversarialSearch;
import aima.core.search.adversarial.AlphaBetaSearch;
import aima.core.search.adversarial.MinimaxSearch;
import aima.core.util.datastructure.XYLocation;

import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Applies Minimax search and alpha-beta pruning to find optimal moves for the
 * Tic-tac-toe game.
 * 
 * @Inha Joo
 */
public class TicTacToeDemo {
	
	
	public static void main(String[] args) {
		System.out.println("TIC-TAC-TOE DEMO");
		System.out.println("");
		startMinimaxDemo();
	}
	
	
	
	

	private static void startMinimaxDemo() {
		System.out.println("MINI MAX DEMO\n");
		System.out.println("Input initial board setup: ");
		
		TicTacToeGame game = new TicTacToeGame();
		TicTacToeState currState = game.getInitialState();
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int counter = 0;
		
		while(st.hasMoreTokens()){
			String token = st.nextToken();
			
			if(token.equals("X") || token.equals("O")){
				currState.alterInitialState(counter, token);
			}
				
			counter++;
		}
		AdversarialSearch<TicTacToeState, XYLocation> search = MMSearch
				.createFor(game);
		
		System.out.println(currState.toString());
		System.out.println(game.getPlayer(currState) + "  playing ... ");
		XYLocation action = (XYLocation) ((MMSearch) search).createDecision(currState);
		//System.out.println(action.toString());
	
		
	
	}


}