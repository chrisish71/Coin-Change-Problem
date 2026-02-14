

function coinChange(coins, amount) {

    function findMinCount(coins, i, currentSum, amount, count, result) {

        if (amount == 0) {
            return 0;
        }

        if (currentSum > amount) {
            return result;
        }

        if (currentSum == amount) {
            result = Math.min(count, result);
            return result;
        }

        if (i <= coins.length - 1) {
            count++;
            result = findMinCount(coins, i, currentSum + coins[i], amount, count, result);
            count--;
            result = findMinCount(coins, i + 1, currentSum, amount, count, result);
        }

        return result;
    }

    var finalResult = findMinCount(coins, 0, 0, amount, 0, amount + 1);

}