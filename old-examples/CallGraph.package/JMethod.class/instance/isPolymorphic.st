querying
isPolymorphic
	^ (calls collect: #args) asSet size > 1