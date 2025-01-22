int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == target) {
                    if(arr[left]==arr[right])
                    {
                        int numberOfDuplicates = right-left+1;
                        count+= numberOfDuplicates * (numberOfDuplicates-1)/2;
                        break;
                    }
                    else
                    {
                    int leftCount = 1, rightCount = 1;

                    // Count duplicates for `left`
                    while (left + 1 < right && arr[left] == arr[left + 1]) {
                        left++;
                        leftCount++;
                    }

                    // Count duplicates for `right`
                    while (right - 1 > left && arr[right] == arr[right - 1]) {
                        right--;
                        rightCount++;
                    }

                    // Add all combinations of duplicates
                    count += leftCount * rightCount;

                    // Move both pointers inward
                    left++;
                    right--;
                    }
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return count;
