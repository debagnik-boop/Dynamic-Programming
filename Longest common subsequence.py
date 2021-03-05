def LCS(p,q,m,n):
    if m == 0 or n == 0:
        return 0
    elif p[m-1]==q[n-1]:
        return 1+LCS(p,q,m-1,n-1)
    else:
        return max(LCS(p,q,m,n-1),LCS(p,q,m-1,n))

def LcsHelper(p,q,m,n):
	memo=[[0 for i in range(n)] for j in range(m)]
	return LcsMemo(memo,p,q,m,n)

def LcsMemo(memo,p,q,m,n):
	if memo[m-1][n-1]!=0:
		return memo[m][n]
	if m == 0 or n == 0:
		result=0
	elif p[m-1]==q[n-1]:
		return 1+LCS(p,q,m-1,n-1)
	else:
		result= max(LCS(p,q,m,n-1),LCS(p,q,m-1,n))
	memo[m-1][n-1]=result
	return result

def LcsDp(p,q):
	m,n=len(p),len(q)
	dp=[[None for i in range(n+1)]for j in range(m+1)]
	for i in range(m+1):
		for j in range(n+1):
			if i==0 or j==0:
				dp[i][j]=0
			elif p[i-1]==q[j-1]:
				dp[i][j]=dp[i-1][j-1]+1
			else:
				dp[i][j]=max(dp[i-1][j],dp[i][j-1])
	return dp[m][n]


s1=input("Enter string 1\t")
s2=input("Enter string 2\t")
m,n=len(s1),len(s2)
print(LcsDp(s1,s2))
