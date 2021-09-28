tests
testNumberOfMultiplyCalledMethods
	self assert: (cg methods select: [ :m | m calls size > 1 ]) size equals: 141