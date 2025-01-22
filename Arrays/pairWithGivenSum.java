int left = 0, right = arr.length - 1;
        int count = 0;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                int leftCount = 1, rightCount = 1;

                // Count duplicates for left
                while (left + 1 < right && arr[left] == arr[left + 1]) {
                    left++;
                    leftCount++;
                }

                // Count duplicates for right
                while (right - 1 > left && arr[right] == arr[right - 1]) {
                    right--;
                    rightCount++;
                }

                // If left and right point to the same element
                if (arr[left] == arr[right]) {
                    count += (leftCount * (leftCount - 1)) / 2; // nC2 for the count
                } else {
                    count += leftCount * rightCount; // Multiply counts
                }

                // Move pointers
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return count;
