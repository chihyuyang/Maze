
public class Tile {
	private TileType type;
	private Tile relatedTile; //for example a door's related tile will be its key and vice a versa
	private boolean walkable;
	private int x;
	private int y;
	
	public Tile(TileType type, Tile relatedTile, boolean walkable, int x, int y){
		this.type = type;
		this.relatedTile = relatedTile;
		this.walkable = walkable;
		this.x = x;
		this.y = y;
	}
	
	public boolean isWalkable() {
		return this.walkable;
	}
	
	public void open(){
		this.walkable = true;
	}
	
	public void close(){
		this.walkable = false;
	}
	
	public TileType getType() {
		return this.type;
	}
}
