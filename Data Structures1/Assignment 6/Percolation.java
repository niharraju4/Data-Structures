package algs15.perc;
import stdlib.*;
import algs15.*;
//Uncomment the import statements above.
//You can test this using InteractivePercolationVisualizer and PercolationVisualizer
//All methods should make at most a constant number of calls to the UF data structure,
//except percolates(), which may make up to N calls to the UF data structure.
public class Percolation {
int N;
boolean[] open;
// tells me if the slot open[k] is open
//declare a UF object here
UF u;
//TODO: more fields to add here
public Percolation(int N) {
this.N = N;
this.open = new boolean[N*N];
this.u = new CompressionUF(N * N);
//this.u = new CompressionUF();  of suitable size... n
//N^2 or N^2 +2 depending on what you do
//TODO: more to do here
}
//open site (row i, column j) if it is not already
public void open(int i, int j) {
open[i*N+j] = true;
if (i+1 < this.N ) {
	if( isOpen(i + 1, j))                      //neighbors of i,j (i+1,j)
{    
	this.u.union(i + 1, j);
}}
if (i-1 > 0) { 
	if( isOpen(i - 1, j) )                  //neighbors of i,j (i - 1, j)
{
	this.u.union(i - 1, j);
}}

if (j+1 < this.N ) {if( isOpen(i, j+1))     //neighbors of i,j (i, j+1)
{
	this.u.union(i , j+1);
}}
if (j-1 > 0 ) {
	if( isOpen(i, j-1))                       //neighbors of i,j ((i, j-1)

{
	this.u.union(i , j-1);
}}

}
//TODO: more to do here.
//union to the neighbors who are open
//neighbors of i,j (i+1,j), (i-1,j), (i,j+1), (i,j-1)
//but be careful of boundary cases
//is site (row i, column j) open?
public boolean isOpen(int i, int j) {
	if((i < 1 || i > N) || (j < 1 || j > N)) {
throw new java.lang.IndexOutOfBoundsException();
	}
return open[i*N+j];

}
//is site (row i, column j) full?
public boolean isFull(int i, int j) {
//TODO
	if((i < 1 || i > N) || (j < 1 || j > N)) {
throw new java.lang.IndexOutOfBoundsException();
	}
//is the slot not open
//opposite of isOpen
return !isOpen(i,j);
}
//does the system percolate?
public boolean percolates() {
	
	for (int i=0;i<=N-1;i++) {                       //slots at the top: (0,0)... (o,N-1)
		for (int j=N*(N-1);j<=N*N;j++) {             //slots at the bottom: (N-1,0,..N-1,N-1)
			if(u.connected(i, j)) {
				return true;
			}
		}
	}
	return false;
//TODO
//N^2 +2: just check whether top is connected to bottom
//N^ 2: 
//check for all in 0th row, whether there is any in last row
//who is connected.
//OR simplify with the idea of adding dummy top and botoom
//return false;
}}

//slots at the top: (0,0)... (o,N-1)
//slots at the bottom: (N-1,0,..N-1,N-1)
//j: loop through the slots at the top
//      j: loops through