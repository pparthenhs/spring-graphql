### Simple Query
Retrieve all owners
```
{
  allOwners{
    name
    id
  }
}
```

### Query for embedded object
Retrieve all car owners
```
{
  allVehicles{
    owner{
     name 
    }
  }
}
```

### Query with argument
Retrieve owners if has the given name
```
{
  allOwnersContainsName(name: "panos") {
    name
  }
}
```

### Query with object
Retrieve total owners vehicles by color
```
{
  isGivenOwnerHasVehiclesWithGivenColor(object: {ownerId: "5b9b6081c6818e1fc3c0c717", carColor: "black"}) {
    text
  }
}
```

### Mutation
Create a new owner by giving this name 
```
mutation{
  createOwner(name: "konstantinos Theodosiou"){
    name
    id
  }
}
```