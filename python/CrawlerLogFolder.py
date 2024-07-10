# 1598. Crawler Log Folder

#The operations are described below:

#"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
#"./" : Remain in the same folder.
#"x/" : Move to the child folder named x (This folder is guaranteed to always exist).
#You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

#The file system starts in the main folder, then the operations in logs are performed.

#Return the minimum number of operations needed to go back to the main folder after the change folder operations.


class Solution(object):
    def minOperations(self, logs):
        res = 0

        for i in logs:
            if i == '../' and res > 0:
                res -= 1
            elif i != './' and i != '../':
                res += 1

        return res
