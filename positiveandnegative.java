class positiveandnegative {

    public static void main(String[] args) {
        // Define an array of ten eight-bit numbers
        byte[] numbers = {10, -5, 3, -7, 0, 15, -2, 8, -1, 6};

        // Call the countPositiveNegative method to get the counts
        int[] counts = countPositiveNegative(numbers);

        // Display the results
        System.out.println("Number of positive numbers: " + counts[0]);
        System.out.println("Number of negative numbers: " + counts[1]);
    }

    // Function to count positive and negative numbers
    public static int[] countPositiveNegative(byte[] numbers) {
        // Initialize counters
        int positiveCount = 0;
        int negativeCount = 0;

        // Iterate through the array
        for (byte number : numbers) {
            if (number > 0) {
                positiveCount++;
            } else if (number < 0) {
                negativeCount++;
            }
            // Ignore zero, as it's not positive nor negative
        }

        // Create an array to store the counts
        int[] counts = {positiveCount, negativeCount};

        // Return the counts
        return counts;
    }
}