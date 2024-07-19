/**
 * @param {number} n
 * @return {boolean}
 */
var isHappy = function (n) {
  // This function calculates the sum of the squares of the digits of a given number
  const getNextNumber = (currentNumber) => {
    let sumOfSquares = 0;
    while (currentNumber !== 0) {
      let digit = currentNumber % 10;
      sumOfSquares += digit ** 2;
      currentNumber = Math.floor(currentNumber / 10);
    }
    return sumOfSquares;
  };

  // Initializes two pointers for detecting cycles
  let slowPointer = n;
  let fastPointer = getNextNumber(n);

  // Uses Floyd's cycle detection algorithm to determine if a cycle exists
  while (slowPointer !== fastPointer) {
    // Moves slow pointer by one step
    slowPointer = getNextNumber(slowPointer);
    // Moves fast pointer by two steps
    fastPointer = getNextNumber(getNextNumber(fastPointer));
  }

  // If fastPointer equals 1, it means we've reached the happy number condition
  return fastPointer === 1;
};
