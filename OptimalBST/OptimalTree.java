import java.util.ArrayList;

public class OptimalTree {
	
	ArrayList<NodeSort> ls = null;
	
	NodeSort createTree(ArrayList<NodeSort> l){
		ls = l;
		double[] probs = new double[ls.size()];
		for(int i = 0; i < probs.length; i++){
			probs[i] = ls.get(i).n.prob;
		}
		
		int[][] map = OptimalBST(probs);
		for(int i = 0; i < map.length; i++){
			/*
			for(int j = 0; j < map[i].length; j++){
				System.out.print("(" + map[i][j] + ") ");
			}
			System.out.println("");
			*/
		}
		
		NodeSort root = this.buildFromMatrix(map);
		
		return root;
		
		//return null;
	}
	
	int[][] OptimalBST( double[] probs ){
		
		int n = probs.length;
		int i,j,k, diagonal;
		double[][] A = new double[n+2][n+2];
		int[][] R = new int[n+2][n+2];
		for(i = 1; i <= n; i++){
			A[i][i-1] = 0;
			R[i][i-1] = 0;
			A[i][i] = probs[i-1];
			R[i][i] = i;
		}
		
		A[n+1][n] = 0;
		R[n+1][n] = 0;
		
		for(diagonal = 1; diagonal <= n-1; diagonal++){
			for(i = 1; i <= n - diagonal; i++){
				j = i + diagonal;
				double MinA = A[i][i-1] + A[i + 1][j];
				double SumP = 0.0;
				int r = i;
				for(k = i; k <= j; k++){
					if(MinA > (A[i][k-1] + A[k + 1][j])){
						MinA = (A[i][k-1] + A[k + 1][j]);
						r = k;
					}
					SumP += probs[k - 1];
				}
				A[i][j] = MinA + SumP;
				R[i][j] = r;
			}
		}
		
		int[][] ret = new int[n][n];
		for(i = 0; i < n; i++){
			for(j = 0; j < n; j++){
				ret[i][j] = Math.max(R[i+1][j+1]-1,-1);
			}
		}
		return ret;
	}
	
	NodeSort buildFromMatrix(int[][] M){
		int L = 0;
		int U = M.length - 1;
		int k = M[L][U];
		NodeSort root = ls.get(k);
		buildAux(L,k-1,M,root);
		buildAux(k+1,U,M,root);
		return root;
	}
	
	void buildAux(int L, int U, int[][] M, NodeSort root){
		//System.out.println("M(" + L + "," + U + ")" );
		if(L > U){
			return;
		}
		int k = M[L][U];
		root.insert(ls.get(k));
		if(U > L){
			buildAux(L,k-1,M,root);
			buildAux(k+1,U,M,root);
		}
	}
}
