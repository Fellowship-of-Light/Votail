package election.tally;

/** 
 * The Candidate object records the number of votes received during
 * each round of counting. Votes can only be added to the candidate's
 * stack while the candidate has a status of <code>CONTINUING</code>.
 * 
 * @see <a href="http://www.cev.ie/htm/tenders/pdf/1_2.pdf">
 * Department of Environment and Local Government, 
 * Count Requirements and Commentary on Count Rules,
 * section 3-14</a>
 * 
 * @author Dermot Cochran
 * @copyright 2005-2009
 */

public class Candidate {
	
/**
 * Maximum expected number of candidates in any one constituency.
 * 
 * @see <a href="http://en.wikipedia.org/wiki/List_of_political_parties_in_the_Republic_of_Ireland">
 * List of political parties in Ireland</a>	
 * 
 * The average number of candidates could be much less.
 */
public static final int MAX_CANDIDATES = 50;

/** Identifier for the candidate.
 * 
 * <BON>
 * class_chart CANDIDATE_ID
 * inherit VALUE
 * constraints
 *   The internal identifier for each candidate is a non negative number
 * end
 * </BON>
 */
/*@ public invariant 0 <= candidateID;
  @ public invariant 0 < candidateID;
  @ public invariant (\forall Candidate a, b;
  @   a != null && b != null;
  @   (a.candidateID == b.candidateID) <==> (a.equals(b)));
  @ public constraint candidateID == \old(candidateID);
  @*/
	protected /*@ spec_public @*/ int candidateID;
	
/** Number of votes added at each count */
/*@ public invariant (\forall int i; 0 < i && i < MAXCOUNT;
  @   0 <= votesAdded[i]);
  @ public initially (\forall int i; 0 < i && i < MAXCOUNT;
  @   votesAdded[i] == 0);	
  @ public invariant votesAdded.length == MAXCOUNT;
  @*/
  protected /*@ spec_public non_null @*/ int[] votesAdded;
	
/** Number of votes removed at each count */
/*@ public invariant (\forall int i; 0 < i && i < MAXCOUNT;
  @                                  0 <= votesRemoved[i]);
  @ public initially (\forall int i; 0 < i && i < MAXCOUNT;
  @                                  votesRemoved[i] == 0);
  @ public invariant votesRemoved.length == MAXCOUNT;
  @*/
  protected /*@ spec_public non_null @*/ int[] votesRemoved;

//@ public invariant votesAdded != votesRemoved;
//@ public invariant votesRemoved != votesAdded;
	
/** The status of the candidate at the latest count */
/*@ public invariant state == ELECTED || state == ELIMINATED ||
  @   state == CONTINUING;
  @ public initially state == CONTINUING;
  @*/      
	protected /*@ spec_public @*/ byte state;
	
/** The number of rounds of counting so far */
//@ public invariant 0 <= lastCountNumber;
//@ public initially lastCountNumber == 0;
//@ public constraint \old(lastCountNumber) <= lastCountNumber;
//@ public invariant lastCountNumber < MAXCOUNT;
	protected /*@ spec_public @*/ int lastCountNumber;
	
/** The count number at which the last set of votes were added */
//@ public invariant 0 <= lastSetAddedCountNumber;
//@ public initially lastSetAddedCountNumber == 0;	
/*@ public constraint 
  @   \old(lastSetAddedCountNumber) <= lastSetAddedCountNumber;
  @*/
//@ public invariant lastSetAddedCountNumber <= lastCountNumber;
	protected /*@ spec_public @*/ int lastSetAddedCountNumber;
	
/**
 * Unique random number used to simulate drawing of lots between candidates.
 */
/*@ public invariant (\forall Candidate a, b;
  @   a != null && b != null;
  @   (a.randomNumber == b.randomNumber) <==> (a.equals(b)));
  @ public constraint randomNumber == \old(randomNumber); 	
  @*/
  protected /*@ spec_public @*/ int randomNumber;
  //@ ghost int _randomNumber;
	
/** State value for a candidate neither elected nor eliminated yet */
	public static final byte CONTINUING = 0;
	
/**
 * State value for a candidate deemed to have been elected either by
 * having a quota or being the highest continuing candidate for the
 * last remaining seat.  
 */	
	public static final byte ELECTED = 1;
	
/**
 * State value for a candidate excluded from election as being one
 * of the lowest continuing candidates at the end of a round of counting.  
 */	
	public static final byte ELIMINATED = 2;	
	
/**
 * State value for a candidate defeated at the last round of the election
 * e.g. the second highest remaining candidate when the last seat is 
 * being filled  
 */	
	public static final byte DEFEATED = 4;	

/**
 * Maximum possible number of counts
 * 
 * @design This value is not set by the legislation; it is chosen so that
 * fixed length arrays can be used in the specification.  
 */	
	public static final int MAXCOUNT = 100;
	
/**
 * Total number of votes this candidate has at any time 
 * 
 * @design This variable was added as to provide easy access from other classes.
 */
	public int total;

	/**
	 * Next available value for candidate ID number. 
	 */
//@ private constraint \old(nextCandidateID) <= nextCandidateID;
private static int nextCandidateID = 1;

	
/**
 * Gets number of votes added or removed in this round of counting.
 * 
 * @param count This count number
 * @return A positive number if the candidate received transfers or 
 * a negative number if the candidate's surplus was distributed or 
 * the candidate was eliminated and votes transfered to another. 
 */	
/*@ 
  @   public normal_behavior
  @     requires 0 <= count && count < MAXCOUNT;
  @     requires count <= lastCountNumber;
  @     ensures \result == votesAdded[count] - votesRemoved[count];
  @*/
	public /*@ pure @*/ int getVoteAtCount(int count){
		return (votesAdded[count] - votesRemoved[count]);
	}
	
/**
 * Total vote received by this candidate less transfers to 
 * other candidates.
 * 
 * @return Net total of votes received
 */	
/*@ public normal_behavior
  @   ensures \result == (\sum int i; 0 <= i && i <= lastCountNumber;
  @     ((votesAdded[i]) - (votesRemoved[i])));
  @*/
	public /*@ pure @*/ int getTotalVote() {
		int totalVote = 0;
		
 		for (int i = 0; i <= lastCountNumber; i++) {
			totalVote += (votesAdded[i] - votesRemoved[i]);
		}
 		
		return totalVote;
	} //@ nowarn Post;
  	
/**
 * Original number of votes received by this candidate before
 * transfers due to elimination or distribution of surplus votes.
 * 
 * @return Gross total of votes received 
 */	
/*@ 
  @   public normal_behavior
  @   ensures \result == (\sum int i; 0 <= i && i <=lastCountNumber;
  @     votesAdded[i]); 
  @   ensures 0 <= \result;
  @*/
	public /*@ pure @*/ int getOriginalVote() {
		int originalVote = 0;
		
 		for (int i = 0; i <= lastCountNumber; i++) {
			originalVote += votesAdded[i];
		}
 		 
		return originalVote;
	} //@ nowarn Post;
	
/**
 * Get status at the current round of counting; {@link #ELECTED}, 
 * {@link #ELIMINATED} or {@link #CONTINUING}
 * 
 *  @return State value for this candidate
 */
/*@ public normal_behavior
  @   ensures \result == state;
  @*/	
	public /*@ pure @*/ byte getStatus(){
		return state;
	}
	
/**
 * Get the unique ID of this candidate.
 * 
 * @return The candidate ID number
 */
/*@ 
  @   public normal_behavior
  @   ensures \result == candidateID;
  @*/	
	public /*@ pure @*/ int getCandidateID() {
 		return candidateID;
	}
	
/**
 * This is the default constructor method for a <code>Candidate</code>
 */	
  public Candidate(){
    state = CONTINUING;
    votesAdded = new int [MAXCOUNT];
    votesRemoved = new int [MAXCOUNT];
    randomNumber = this.hashCode();
    candidateID = nextCandidateID++;
    //@ set _randomNumber = randomNumber;
  } //@ nowarn;

/**
 * Add a number of votes to the candidate's ballot stack.
 * 
 * @design This method cannot be called twice for the same candidate
 * in the same round of counting.
 * 
 * @param numberOfVotes Number of votes to add
 * @param count The round of counting at which the votes were added
 */	
/*@  
  @   public normal_behavior
  @   requires state == CONTINUING;
  @   requires lastCountNumber < count;
  @   requires votesAdded[count] == 0;
  @   requires 0 < count & count < MAXCOUNT;
  @   requires 0 <= numberOfVotes;
  @   assignable lastCountNumber, votesAdded[count], lastSetAddedCountNumber;
  @   ensures votesAdded[count] == numberOfVotes;
  @   ensures lastCountNumber == count;
  @   ensures lastSetAddedCountNumber == count;
  @*/
  public void addVote(int numberOfVotes, int count){
       votesAdded[count] = numberOfVotes;
       lastCountNumber = count;
       lastSetAddedCountNumber = count;
  } //@ nowarn;

/**
 * Removes a number of votes from a candidates ballot stack.
 * 
 * @design This method cannot be called twice for the same candidate
 * in the same round of counting.
 * 
 * @param numberOfVotes Number of votes to remove from this candidate
 * @param count The round of counting at which the votes were removed 
 */	
/*@ 
  @   public normal_behavior
  @   requires state == ELIMINATED || state == ELECTED;
  @   requires lastCountNumber < count;
  @   requires votesRemoved[count] == 0;
  @   requires 0 < count & count < MAXCOUNT;
  @   requires 0 <= numberOfVotes;
  @   assignable lastCountNumber, votesRemoved[count];
  @   ensures votesRemoved[count] == numberOfVotes;
  @   ensures lastCountNumber == count;
  @*/
  public void removeVote(final int numberOfVotes, final int count){
        votesRemoved[count] = numberOfVotes;
        lastCountNumber = count;
    } //@ nowarn;
	
/** Declares the candidate to be elected */
/*@ public normal_behavior
  @   requires state == CONTINUING;
  @   assignable state;
  @   ensures state == ELECTED;
  @*/
	public void declareElected(){
		state = ELECTED;
	} //@ nowarn;
	
/** Declares the candidate to be eliminated */
/*@ public normal_behavior
  @   requires state == CONTINUING;
  @   assignable state;
  @   ensures state == ELIMINATED;
  @*/
	public void declareEliminated(){
		state = ELIMINATED;
	} //@ nowarn;
	
/**
 * Gets number of votes in last set of votes added
 * 
 * @design In the first round of counting this is the same as
 * the number of first preferences, otherwise it is the most
 * recent set of votes received. The last set of votes received are
 * the only votes considered when a surplus is being distributed.
 * 
 * @return The number of votes in the last set added 
 */	
/*@ public normal_behavior
  @   ensures \result == votesAdded[lastSetAddedCountNumber];
  @*/
	public /*@ pure @*/ int getNumberOfVotesInLastSet(){
		int number = votesAdded[lastSetAddedCountNumber];
		return number;
	}

/**
 * Gets the count number at which the last set of votes was added.
 * 
 * @design This is needed to check which ballots are in the last 
 * set added
 * 
 * @see "requirement 19, section 7, item 2, page 19"
 * 
 * @return The last count number at which votes were added
 */	
/*@ public normal_behavior
  @   ensures \result == lastSetAddedCountNumber;
  @*/
	public /*@ pure @*/ int getLastSetAddedCountNumber(){
		return lastSetAddedCountNumber;
	}	
	
/**
 * Compares with another candidate's secret random number.
 * 
 * @design It is intended to be able to compare random numbers without
 * revealing the exact value of the random number, so that the random
 * number cannot be manipulated in any way.
 * 
 * @param other other candidate to compare with this candidate
 * 
 * @return <code>true</true> if other candidate has lower random number
 */	
/*@ 
  @ public normal_behavior
  @ ensures (\result == true) <==>
  @   (this.randomNumber > other.randomNumber);
  @*/
	public /*@ pure @*/ boolean isAfter(/*@ non_null @*/ Candidate other){
		return (this.randomNumber > other.randomNumber);
	}
	
/**
 * Is this the same candidate?
 * 
 * @param other The candidate to be compared
 * 
 * @return <code>true</code> if this is the same candidate
 */
/*@ public normal_behavior
  @   ensures \result <==> ((other != null) &&
  @     (other.getCandidateID() == candidateID));
  @*/
	public /*@ pure @*/ boolean equals(final Candidate other) {
		if (other == null) {
			return false;
		}
		return (other.getCandidateID() == this.candidateID);
	}

public long getTotalAtCount(int count) {
	long totalAtCount = 0;
	
	for (int i = 0; i <= count; i++) {
		totalAtCount += getVoteAtCount(i);
	}
	
	return totalAtCount;
}
}