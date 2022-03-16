//package com.oraclesample.oraclesec.cart;
//
//@RestController
//@RequestMapping("/cart")
//public class CartController {
//    @Autowired
//    private CartService cartService;
//
//    @Autowired
//    private ProductService productService;
//
//    @Autowired
//    private AuthenticationService authenticationService;
//
//    @PostMapping("/add")
//    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto, @RequestParam("token") String token) throws AuthenticationFailException, ProductNotExistException {
//        authenticationService.authenticate(token);
//
//        int userId = authenticationService.getUser(token).getId();
//
//        cartService.addToCart(addToCartDto,userId);
//
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
//
//    }
//    @GetMapping("/")
//    public ResponseEntity<CartCost> getCartItems(@RequestParam("token") String token) throws AuthenticationFailException {
//        authenticationService.authenticate(token);
//        int userId = authenticationService.getUser(token).getId();
//        CartCost cartCost = cartService.listCartItems(userId);
//        return new ResponseEntity<CartCost>(cartCost,HttpStatus.OK);
//    }
//    @PutMapping("/update/{cartItemId}")
//    public ResponseEntity<ApiResponse> updateCartItem(@RequestBody @Valid AddToCartDto cartDto,
//                                                      @RequestParam("token") String token) throws AuthenticationFailException,ProductNotExistException {
//        authenticationService.authenticate(token);
//        int userId = authenticationService.getUser(token).getId();
//
//        Product product = productService.getProductById(cartDto.getProductId());
//
//        cartService.updateCartItem(cartDto,userId,product);
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Product has been updated"), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{cartItemId}")
//    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItemId") int itemID,@RequestParam("token") String token) throws AuthenticationFailException, CartItemNotExistException {
//        authenticationService.authenticate(token);
//
//        int userId = authenticationService.getUser(token).getId();
//
//        cartService.deleteCartItem(itemID,userId);
//        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
//    }
//
//}