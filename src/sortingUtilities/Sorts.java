package sortingUtilities;

public class Sorts {

	public Sorts() {
	}

	/**
	 * Method to allow for bubble sort. 
	 * 
	 * Sourced from: 
	 * https://stackoverflow.com/questions/22328181/using-a-seperate-bubble-sort-class-to-sort-objects-based-on-field-of-double
	 * http://www.java-examples.com/java-bubble-sort-example
	 *  
	 * @param polygonArray
	 * @param length
	 */
	public static void bubbleSort(Comparable[] polygonArray, int length) {
	
			Comparable tempVar = null;

			for(int i=0; i < polygonArray.length; i++){
				for(int j=1; j < (polygonArray.length-i); j++){

					if(polygonArray[j-1].compareTo(polygonArray[j])> 0){
						//swap the elements!
						tempVar = polygonArray[j-1];
						polygonArray[j-1] = polygonArray[j];
						polygonArray[j] = tempVar;
					}

				}
			}

		}
		
	//First attempt at Bubble Sort
//		 Comparable tempVar;
//		 
//		  for( int i = 0; i < polygonArray.length - 1; i++ ) 
//		  {
//		    for( int j = 0; j < polygonArray.length  - 1; j++ ) 
//		    {
//		      if( polygonArray[i].compareTo(polygonArray[j + 1]) < 0 ) 
//		      {
//		        tempVar = polygonArray[j + 1];
//		        polygonArray[j + 1] = polygonArray[i];
//		        polygonArray[i] = tempVar;
//		      }
//		    }
//		  }
//	}

	/**
	 * Method to allow for selection sort
	 * 
	 * Sourced from:
	 * http://web.cs.iastate.edu/~smkautz/cs227f12/examples/week11/SelectionSortExamples.java
	 * 
	 * @param polygonArray
	 * @param length
	 */
	public static void selectionSort(Comparable[] polygonArray, int length) {
		// TODO Auto-generated method stub
		
		Comparable tempVar;
		
		for (int i = 0; i < polygonArray.length - 1; ++i)
	    {
	      int minIndex = i;
	      for (int j = i + 1; j < polygonArray.length; ++j)
	      {
	        if (polygonArray[j].compareTo(polygonArray[minIndex]) < 0)
	        {
	          minIndex = j;
	        }
	      }
	      
	      tempVar = polygonArray[i];
	      polygonArray[i] = polygonArray[minIndex];
	      polygonArray[minIndex] = tempVar;
	    }
	  }
		
	/**
	 * Method to allow for insertion sort on the polygon array
	 * 
	 * Sourced from: 
	 * https://stackoverflow.com/questions/23408461/insertion-sort-for-an-object-array
	 * 
	 * @param polygonArray
	 * @param length
	 */
	public static void insertionSort(Comparable[] polygonArray, int length) {
		// TODO Auto-generated method stub
		Comparable tempVar;
		
		for(int i = 2; i < polygonArray.length; i++){
	        int j=i-1;
	        tempVar = polygonArray[i];
	        while((j>-1) && ((polygonArray[j].compareTo(tempVar)>0))){
	        	polygonArray[j+1]=polygonArray[j];
	            j--;
	        }
	        
	        polygonArray[j+1] = tempVar;
	    }
	}

	/**
	 * Method to allow for the merge sorting of the polygon Array data
	 * 
	 * Sourced From: http://www.geeksforgeeks.org/merge-sort/
	 * 
	 * @param polygonArray
	 * @param l
	 * @param r
	 */
	public static void mergeSort(Comparable[] polygonArray, int l, int r) {
		// TODO Auto-generated method stub
            Comparable [ ] tmpArray = new Comparable[ polygonArray.length ];

            mergeSort( polygonArray, tmpArray, 0, polygonArray.length - 1 );
        }

        /**
         * Internal method that makes recursive calls.
         * @param a an array of Comparable items.
         * @param tmpArray an array to place the merged result.
         * @param left the left-most index of the subarray.
         * @param right the right-most index of the subarray.
         */
        private static void mergeSort( Comparable [ ] polygonArray, Comparable [ ] tmpArray,
                   int left, int right )
        {
            if( left < right )
            {
                int center = ( left + right ) / 2;
                mergeSort( polygonArray, tmpArray, left, center );
                mergeSort( polygonArray, tmpArray, center + 1, right );
                merge( polygonArray, tmpArray, left, center + 1, right );
            }
        }

        /**
         * Internal method that merges two sorted halves of a subarray.
         * 
         * @param a an array of Comparable items.
         * @param tmpArray an array to place the merged result.
         * @param leftPos the left-most index of the subarray.
         * @param rightPos the index of the start of the second half.
         * @param rightEnd the right-most index of the subarray.
         */
        private static void merge( Comparable [ ] polygonArray, Comparable [ ] tmpArray,
               int leftPos, int rightPos, int rightEnd )
        {
            int leftEnd = rightPos - 1;
            int tmpPos = leftPos;
            int numElements = rightEnd - leftPos + 1;

            // Main loop
            while( leftPos <= leftEnd && rightPos <= rightEnd )
                if( polygonArray[ leftPos ].compareTo( polygonArray[ rightPos ] ) <= 0 )
                    tmpArray[ tmpPos++ ] = polygonArray[ leftPos++ ];
                else
                    tmpArray[ tmpPos++ ] = polygonArray[ rightPos++ ];

            while( leftPos <= leftEnd )    // Copy rest of first half
                tmpArray[ tmpPos++ ] = polygonArray[ leftPos++ ];

            while( rightPos <= rightEnd )  // Copy rest of right half
                tmpArray[ tmpPos++ ] = polygonArray[ rightPos++ ];

            // Copy tmpArray back
            for( int i = 0; i < numElements; i++, rightEnd-- )
            	polygonArray[ rightEnd ] = tmpArray[ rightEnd ];
        }

	/**
	 * Method to allow for quicksort on the polygon Array data
	 * 
	 * Sourced from:
	 * https://stackoverflow.com/questions/29592021/using-comparator-in-custom-quicksort-in-java
	 * 
	 * @param polygonArray
	 * @param left
	 * @param right
	 */
	public static void quickSort(Comparable[] polygonArray, int left, int right) {
		// TODO Auto-generated method stub
		
		 int ll = left;
	        int rr = right;

	        if (rr>ll)
	        {
	            Comparable pivot = polygonArray[(ll+rr)/2];
	            while (ll <=rr){
	                while(ll<right && polygonArray[ll].compareTo(pivot) < 0){
	                    ll +=1;
	                }
	                while(rr>left && polygonArray[rr].compareTo(pivot) > 0){
	                    rr -=1;
	                }
	                if (ll <=rr){
	                    swap(polygonArray, ll ,rr);
	                    ll +=1;
	                    rr -=1; 
	                }
	            }
	            if (left < rr){
	            	quickSort(polygonArray,left,rr);

	            }
	            if (ll<right){
	            	quickSort(polygonArray,ll,right);
	            }
	        }
	    }

	    static void swap(Comparable[] polygonArray, int l, int r) 
	    {
	        Comparable t = polygonArray[l];
	        polygonArray[l] = polygonArray[r];
	        polygonArray[r] = t;
	    }
		 
	/**
	 * Method to allow for the shell sort on the polygon array data
	 * 
	 * Sourced From: https://stackoverflow.com/questions/4833423/shell-sort-java-example
	 * Sourced From: Data Structures & Algorithm Analysis in Java (book)
	 * Sourced Complexity From: https://en.wikipedia.org/wiki/Shellsort
	 * 
	 * Time Complexity: 
	 * Worst Case: O(n^2)
	 * 
	 * @param polygonArray
	 */
	@SuppressWarnings("unchecked")
	public static void shellSort(@SuppressWarnings("rawtypes") Comparable[] polygonArray) { 
		//TODO
		int j;
	    for( int gap = polygonArray.length / 2; gap > 0; gap /= 2 )
	    {
	      for( int i = gap; i < polygonArray.length; i++ )
	      {
	         @SuppressWarnings("rawtypes")
			Comparable tempVar = polygonArray[ i ];
	         for( j = i; j >= gap && tempVar.compareTo( polygonArray[ j - gap ] ) < 0; j -= gap )
	         {
	        	 polygonArray[ j ] = polygonArray[ j - gap ];
	         }
	         polygonArray[ j ] = tempVar;
	      }
	    }
	  }
	}
		

	
