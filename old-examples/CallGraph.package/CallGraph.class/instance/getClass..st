accessing
getClass: aClassName 
	^ classes at: aClassName ifAbsentPut: [ JClass new name: aClassName ]