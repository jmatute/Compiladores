type esto
  dim a as integer
  dim b as boolean
  dim c as variant
  end type


function otra(byval a as boolean) as integer
  dim hola as string
  dim adios as esto
  dim aquello as variant
  hola ="hola"
  aquello = "aquello"
  aquello = blah()
  c = 5
  otra = 5
  write aquello
  write adios.a
  write blah()
end function

function esta(byval cad as string,byref i as integer) as boolean
  return true
end function

function uno(byval dos as string) as integer
  h = 4
  return h
end function

function dos(byval a as char) as integer
  DIM x as variant
  x = true
  return 5
end function
dim c as integer
sub blah()
  return
end sub

Sub main()
  dim a as variant
  dim b as integer
  dim c as boolean
  a = 4
  b = 3 - a
  blah()
  b = 3 +1 + a
  a = true
  a = not a
  if a then
    write "hello"
  end if
  uno("h")
  esta("hola",2)
end sub
