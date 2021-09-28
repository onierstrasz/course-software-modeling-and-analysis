tests
testNumberOfMultiplyCalledMethods
	self assert: (CallGraph example methods select: [ :m | m calls size > 1 ]) size equals: 0